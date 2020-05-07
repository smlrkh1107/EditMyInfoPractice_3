package kr.tjeit.editmyinfopractice_20200506.datas

import org.json.JSONObject

class Category {

    companion object {
        fun getCategoryFromJson(json: JSONObject) : Category {
            val ct = Category()
            ct.id = json.getInt("id")
            ct.title = json.getString("title")
            ct.color = json.getString("color")
            return ct
        }
    }
//
    var id = 0
    var title = ""
    var color = ""

    override fun equals(other: Any?): Boolean {
        val otherCategory = other as Category
//        if (this.id == otherCategory.id){
//            return true
//        }
//        else {return false}
//        줄여쓰렴^^
        return this.id == otherCategory.id
    }

}