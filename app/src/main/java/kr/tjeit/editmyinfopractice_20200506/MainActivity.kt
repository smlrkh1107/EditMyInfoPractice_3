package kr.tjeit.editmyinfopractice_20200506

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.tjeit.editmyinfopractice_20200506.utils.ServerUtil
import org.json.JSONObject

class MainActivity : BaseActivity() {

    lateinit var token:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        token = intent.getStringExtra("token")!!

        Log.d("로그인유져토큰", token)

//        토큰을 가지고 => 사용자 정보를 불러오기
//          => User클래스형태로 파싱 => UI에 값을 찍어주기. (자기소개까지)

        ServerUtil.getRequestMyInfo(mContext, token, object : ServerUtil.JsonResponseHandler {
            override fun onResponse(json: JSONObject) {
                Log.d("내정보응답", json.toString())
            }

        })




    }

}
