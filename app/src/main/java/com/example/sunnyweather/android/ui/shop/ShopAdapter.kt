package com.example.sunnyweather.android.ui.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.sunnyweather.R
import com.jay.widget.StickyHeaders


class ShopAdapter(private val  fragment:Fragment,private val list:ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() ,StickyHeaders {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view =LayoutInflater.from(fragment.context).inflate(viewType,parent,false)
        var viewHolder:RecyclerView.ViewHolder
       when(viewType){
           0 -> viewHolder=HeadViewHolder(view)
           1 -> viewHolder=RecommendViewHolder(view)
           else ->viewHolder=ViewHolder(view)
       }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is RecommendViewHolder ->{

            }
            is HeadViewHolder ->
                    holder as HeadViewHolder
        }
    }

    override fun getItemCount(): Int {
        return list?.size
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

    class RecommendViewHolder(view:View):RecyclerView.ViewHolder(view){
        val recommend1:Button=view.findViewById(R.id.btn_recommend1)
        val recommend2:Button=view.findViewById(R.id.btn_recommend2)
        val recommend3:Button=view.findViewById(R.id.btn_recommend3)
    }


    class HeadViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun isStickyHeader(p0: Int): Boolean {
        return p0==1
    }
}