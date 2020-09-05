package com.example.sunnyweather.android.ui.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sunnyweather.R
import com.jay.widget.StickyHeaders


class ShopAdapter(private val context: Context,private val list:List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() ,StickyHeaders {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view =LayoutInflater.from(context).inflate(viewType,parent,false)
        var viewHolder:RecyclerView.ViewHolder
       when(viewType){
           0 -> viewHolder=HeadViewHolder(view)
           1 -> viewHolder=RecommendViewHolder(view)
           else ->viewHolder=ViewHolder(view)
       }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun getItemViewType(position: Int): Int {
        return if (position==0){
            R.layout.shop_item_head
        } else if(position==1){
            R.layout.shop_itemc_recommend
        }else {
            R.layout.shop_item
        }
    }



    class ViewHolder(view :View):RecyclerView.ViewHolder(view)

    class RecommendViewHolder(view:View):RecyclerView.ViewHolder(view)

    class HeadViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun isStickyHeader(p0: Int): Boolean {
        return p0==1
    }
}