package kr.tjeit.editmyinfopractice_20200506.adapters

import android.content.Context
import android.icu.util.ULocale
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kr.tjeit.editmyinfopractice_20200506.R
import kr.tjeit.editmyinfopractice_20200506.datas.Category

class CategorySpinnerAdapter(val mContext: Context, val resId:Int, val mList:ArrayList<Category>)
    : ArrayAdapter<Category>(mContext, resId, mList){


    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.category_list_item, null)
        }
        val row = tempRow!!
        return row
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.category_list_item, null)
        }
        val row = tempRow!!
        return row

    }



}