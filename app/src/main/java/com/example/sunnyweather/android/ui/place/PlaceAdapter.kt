package com.example.sunnyweather.android.ui.place

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sunnyweather.R
import com.example.sunnyweather.android.logic.model.Place
import com.example.sunnyweather.android.logic.model.Weather
import com.example.sunnyweather.android.ui.weather.WeatherActivity
import kotlinx.android.synthetic.main.activity_weather.*
import org.w3c.dom.Text

class PlaceAdapter(private val fragment:PlaceFragment,private val placeList:List<Place>):RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
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
        val holder=ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position=holder.adapterPosition
            val place=placeList[position]
            val activity=fragment.activity
            if (activity is WeatherActivity){
                activity.drawerLayout.closeDrawers()
                activity.viewModel.locationLng=place.location.lng
                activity.viewModel.locationLat=place.location.lat
                activity.viewModel.placeName=place.name
                activity.refreshWeather()
            }else{
                val intent=Intent(parent.context,WeatherActivity::class.java).apply {
                    putExtra("location_lng",place.location.lng)
                    putExtra("location_lat",place.location.lat)
                    putExtra("place_name",place.name)
                }
                fragment.startActivity(intent)
                fragment.activity?.finish()

            }
            fragment.viewModel.savePlace(place)
        }
        return  holder
    }

    inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val palceName:TextView =view.findViewById(R.id.placeName)
        val placeAddress:TextView=view.findViewById(R.id.placeAddress)
    }

}