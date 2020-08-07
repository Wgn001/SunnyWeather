package com.example.sunnyweather.android.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sunnyweather.R
import com.example.sunnyweather.android.logic.model.Place
import org.w3c.dom.Text

class PlaceAdapter(private val fragment:Fragment,private val placeList:List<Place>):RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val place=placeList[position]
            holder.palceName.text=place.name
            holder.placeAddress.text=place.address
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        return  ViewHolder(view);
    }

    inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val palceName:TextView =view.findViewById(R.id.placeName)
        val placeAddress:TextView=view.findViewById(R.id.placeAddress)
    }

}