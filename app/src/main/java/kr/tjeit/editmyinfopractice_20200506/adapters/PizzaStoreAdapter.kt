package kr.tjeit.editmyinfopractice_20200506.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.tjeit.editmyinfopractice_20200506.R
import kr.tjeit.editmyinfopractice_20200506.datas.PizzaStore

class PizzaStoreAdapter(val mContext: Context, resId:Int, val mList:ArrayList<PizzaStore>) : ArrayAdapter<PizzaStore>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.pizza_store_item, null)
        }

        val row = tempRow!!

        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)

        val data = mList.get(position)

        nameTxt.text = data.name
        Glide.with(mContext).load(data.imgUrl).into(logoImg)

        return row
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.pizza_store_spinner_dropdown_item, null)
        }

        val row = tempRow!!

        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)

        val data = mList.get(position)

        nameTxt.text = data.name
        Glide.with(mContext).load(data.imgUrl).into(logoImg)

        return row

    }


}