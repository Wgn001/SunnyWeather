package com.example.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.example.sunnyweather.android.logic.model.Place
import com.example.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository{
    fun searchPlaces(query:String) = liveData(Dispatchers.IO) {
        val result=try{
            //请求网络数据
        val placeResponse =SunnyWeatherNetwork.searchPlaces(query)
        if (placeResponse.status=="ok"){
            val places=placeResponse.places
            Result.success(places)
        }else{
            Result.failure(RuntimeException("response status is ${placeResponse.status}"))
        }
    }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }

        //发射结果
        emit(result)
    }
}