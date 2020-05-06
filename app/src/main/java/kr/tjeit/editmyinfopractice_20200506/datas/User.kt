package kr.tjeit.editmyinfopractice_20200506.datas

import org.json.JSONObject
import java.util.*

class User {

    companion object {
        fun getUserFromJsonObject(json: JSONObject) : User {
            val parsedUser = User()
            parsedUser.id = json.getInt("id")
            parsedUser.loginId = json.getString("login_id")
            parsedUser.name = json.getString("name")
            parsedUser.phoneNum = json.getString("phone")
            parsedUser.memo = json.getString("memo")

            parsedUser.category = Category.getCategoryFromJson(json.getJSONObject("category"))

//            parsedUser.createdAt.set()

            return parsedUser
        }
    }

    var id = 0
    var loginId = ""
    var name = ""
    var phoneNum = ""
    var memo = ""

    val createdAt = Calendar.getInstance()
    var category = Category()

}