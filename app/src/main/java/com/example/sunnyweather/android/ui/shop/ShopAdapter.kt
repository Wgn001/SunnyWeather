package com.example.sunnyweather.android.ui.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.sunnyweather.R
import com.jay.widget.StickyHeaders


class ShopAdapter(private val  fragment:Fragment,private val shopViewModel: ShopViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() ,StickyHeaders {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view =LayoutInflater.from(fragment.context).inflate(viewType,parent,false)
        var viewHolder:RecyclerView.ViewHolder
       when(viewType){
           R.layout.shop_item_head -> viewHolder=HeadViewHolder(view)
           R.layout.shop_itemc_recommend -> viewHolder=RecommendViewHolder(view)
           else ->viewHolder=ViewHolder(view)
       }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is RecommendViewHolder ->{

                holder.recommend1.setOnClickListener {
                    shopViewModel.changeRecommend(3)
                }
                holder.recommend2.setOnClickListener {
                    shopViewModel.changeRecommend(6)
                }
                holder.recommend3.setOnClickListener {
                    shopViewModel.changeRecommend(10)
                }
                holder.recommend4.setOnClickListener {
                    shopViewModel.changeRecommend(15)
                }
            }

        }

    }



    override fun getItemCount(): Int {
        return shopViewModel.recommendList.size
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
        val recommend4:Button=view.findViewById(R.id.btn_recommend4)
    }


    class HeadViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun isStickyHeader(p0: Int): Boolean {
        return p0==1
    }
}