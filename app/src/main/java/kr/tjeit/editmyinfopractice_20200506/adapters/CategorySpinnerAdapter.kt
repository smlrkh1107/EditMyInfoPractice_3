package kr.tjeit.editmyinfopractice_20200506.adapters

import android.content.Context
import android.graphics.Color
import android.icu.util.ULocale
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kr.tjeit.editmyinfopractice_20200506.R
import kr.tjeit.editmyinfopractice_20200506.datas.Category

class CategorySpinnerAdapter(val mContext: Context, val resId:Int, val mList:ArrayList<Category>)
    : ArrayAdapter<Category>(mContext, resId, mList){


    val inf = LayoutInflater.from(mContext)

    
//    선택된거 보여줌
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.category_list_item, null)
        }

        val row = tempRow!!
        val colorImg = row.findViewById<ImageView>(R.id.colorImg)
        val titleTxt = row.findViewById<TextView>(R.id.titleTxt)

        val data = mList.get(position)

        titleTxt.text = data.title
//        kotlin set background color ???(R.color.green) [ 구글링]

        colorImg.setBackgroundColor(Color.parseColor(data.color))


        return row
    }

//    목록에 뿌려짐
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.category_list_item, null)
        }

        val row = tempRow!!
        val colorImg = row.findViewById<ImageView>(R.id.colorImg)
        val titleTxt = row.findViewById<TextView>(R.id.titleTxt)

        val data = mList.get(position)

        titleTxt.text = data.title
//        kotlin set background color ???(R.color.green) [ 구글링]

        colorImg.setBackgroundColor(Color.parseColor(data.color))


        return row

    }



}