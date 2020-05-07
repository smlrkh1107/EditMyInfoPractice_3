package kr.tjeit.editmyinfopractice_20200506

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kr.tjeit.editmyinfopractice_20200506.adapters.CategorySpinnerAdapter
import kr.tjeit.editmyinfopractice_20200506.datas.Category
import kr.tjeit.editmyinfopractice_20200506.datas.User
import kr.tjeit.editmyinfopractice_20200506.utils.ServerUtil
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity() {

    lateinit var token:String
    lateinit var categoryAdapter: CategorySpinnerAdapter
    val categoryList = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        getCategoryListFromServer()

        token = intent.getStringExtra("token")!!
        categoryAdapter = CategorySpinnerAdapter(mContext, R.layout.category_list_item, categoryList)
        categorySpinner.adapter = categoryAdapter

        Log.d("로그인유져토큰", token)

//        토큰을 가지고 => 사용자 정보를 불러오기
//          => User클래스형태로 파싱 => UI에 값을 찍어주기. (자기소개까지)

        ServerUtil.getRequestMyInfo(mContext, token, object : ServerUtil.JsonResponseHandler {
            override fun onResponse(json: JSONObject) {
                Log.d("내정보응답", json.toString())

                val code = json.getInt("code")

                if (code == 200) {

                    val data = json.getJSONObject("data")
                    val user = data.getJSONObject("user")

                    val userObj = User.getUserFromJsonObject(user)

//                    만들어낸 사용자 객체를 화면에 반영 (UI작업)

                    runOnUiThread {

                        idTxt.text = userObj.loginId
                        nameEdt.setText(userObj.name)
                        phoneNumEdt.setText(userObj.phoneNum)
                        memoEdt.setText(userObj.memo)

//                        Calendal 가입일시 > String으로 변환.
//                        텍스트뷰에 대입

                        val printSdf = SimpleDateFormat("yyyy년 M월 d일 (E)")
                        signUpDateTxt.text = printSdf.format(userObj.createdAt.time)

////                        사람1 1988-10-20 생일 / 사람2 1988-08-08 (요일양식추가 예시)
//                        val man1BirthDay = Calendar.getInstance()
//                        val man2BirthDay = Calendar.getInstance()
//
////                        월은 0부터 시작이라서 맘편히 이렇게 적는게 나아.
//                        man1BirthDay.set(1988, Calendar.OCTOBER, 20)
//                        man2BirthDay.set(1988, Calendar.AUGUST, 8)

                    }

                }

            }

        })


    }

    fun getCategoryListFromServer() {
        ServerUtil.getRequestUserCategory(mContext, object:ServerUtil.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("카테고리목록", json.toString())
                val code = json.getInt("code")

                if (code==200){
                    val data = json.getJSONObject("data")
                    val userCategories = data.getJSONArray("user_categories")

//                   얜 이름이없어,,, 배열안에 오브젝트 순서만 있을 뿐.
                    for (i in 0..userCategories.length()-1){
                        val uc = userCategories.getJSONObject(i)
                        val categoryObj = Category.getCategoryFromJson(uc)
                        categoryList.add(categoryObj) //서버다녀오는게 멀어서 시간이 걸려..
                    }
//                어댑터의 ArrayList에 내용 변화 (객체 추가)
                    runOnUiThread {
                        categoryAdapter.notifyDataSetChanged()
                    }

                }
            }
        })

    }



}
