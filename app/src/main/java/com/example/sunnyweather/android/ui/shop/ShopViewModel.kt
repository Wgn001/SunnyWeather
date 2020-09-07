package com.example.sunnyweather.android.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopViewModel :ViewModel(){

    val recommendList = MutableLiveData<List<String>>()

    fun getRecommendList():List<String>{
        return listOf("")
    }

}