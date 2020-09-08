package com.example.sunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.android.logic.Repository
import com.example.sunnyweather.android.logic.model.Place

class PlaceViewModel : ViewModel() {


    fun savePlace(place: Place)=Repository.savePlace(place)

    fun getSavePlace()=Repository.getSavePlace()

    fun isPlaceSaved()=Repository.isPlaceSaved()

    //注册ViewModel
    private val searchLiveData =MutableLiveData<String>()

    //RecyclerView数据源
    val placelist=ArrayList<Place>()

    //转换数据类型,searchLiveData监听时时Observable
    val placeLiveData =Transformations.switchMap(searchLiveData){   query->
            Repository.searchPlaces(query)
        }

    /**
     * 搜索
     */
    fun searchPlaces(query :String){
        searchLiveData.value=query
    }

}