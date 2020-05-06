package kr.tjeit.editmyinfopractice_20200506

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kr.tjeit.editmyinfopractice_20200506.utils.ServerUtil
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        loginBtn.setOnClickListener {
            val id = idEdt.text.toString()
            val pw = pwEdt.text.toString()

            ServerUtil.postRequestLogin(mContext, id, pw, object : ServerUtil.JsonResponseHandler {
                override fun onResponse(json: JSONObject) {
                    Log.d("로그인응답", json.toString())

                    val code = json.getInt("code")

                    if (code == 200) {
                        val data = json.getJSONObject("data")
                        val userToken = data.getString("token")

                        val myIntent = Intent(mContext, MainActivity::class.java)
                        myIntent.putExtra("token", userToken)
                        startActivity(myIntent)

                    }
                    else {
                        runOnUiThread {
                            Toast.makeText(mContext, "로그인 실패", Toast.LENGTH_SHORT).show()
                        }
                    }

                }

            })

        }

    }

    override fun setValues() {

    }

}
