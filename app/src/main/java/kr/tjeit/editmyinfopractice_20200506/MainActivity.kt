package kr.tjeit.editmyinfopractice_20200506

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

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

    }

}
