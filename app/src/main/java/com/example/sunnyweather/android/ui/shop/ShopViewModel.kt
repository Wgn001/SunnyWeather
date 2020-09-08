package com.example.sunnyweather.android.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ShopViewModel :ViewModel(){

    private val recommend=MutableLiveData<String>()

    val recommendLiveData=Transformations.map(recommend){
        getRecommend()
    }

    val recommendList=ArrayList<String>()

    fun getRecommend():List<String>{
        return listOf<String>("","","")
    }

    fun changeRecommend(query:String){
        recommend.value=query
    }
}