package kr.tjeit.editmyinfopractice_20200506

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kr.tjeit.editmyinfopractice_20200506.adapters.PizzaStoreAdapter
import kr.tjeit.editmyinfopractice_20200506.datas.PizzaStore

class MainActivity : BaseActivity() {

    lateinit var myAdapter : PizzaStoreAdapter
    val pizzaStores = ArrayList<PizzaStore>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        jobSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("선택된아이템포지션", "${position}번째 아이템 선택")
//                Toast.makeText(mContext, "${position}번째 아이템 선택", Toast.LENGTH_SHORT).show()
            }

        }

        okBtn.setOnClickListener {
//            스피너에 선택된 문구를 로그로 출력.
            val selectedJob = jobSpinner.selectedItem as String
            Log.d("선택된 직업", selectedJob)

            val selectedPosition = jobSpinner.selectedItemPosition
            Log.d("선택된 위치", "${selectedPosition}번째 아이템")
        }

    }

    override fun setValues() {
        addPizzaStores()

        myAdapter = PizzaStoreAdapter(mContext, R.layout.pizza_store_item, pizzaStores)
        pizzaSpinner.adapter = myAdapter
    }

    private fun addPizzaStores() {

        pizzaStores.add(PizzaStore("피자헛", "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
        pizzaStores.add(PizzaStore("파파존스", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800"))
        pizzaStores.add(PizzaStore("미스터피자", "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200"))
        pizzaStores.add(PizzaStore("도미노피자", "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png"))

    }

}
