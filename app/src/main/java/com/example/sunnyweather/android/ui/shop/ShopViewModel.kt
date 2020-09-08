package com.example.sunnyweather.android.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ShopViewModel :ViewModel(){

    //recyclerView 的List
    private val recommend=MutableLiveData<Int>()

    //转换
    val recommendLiveData=Transformations.map(recommend){count ->
        getRecommend(count)
    }

    val recommendList=ArrayList<String>()

    fun getRecommend(count :Int):List<String>{
        val lists=ArrayList<String>()
        for (i in 0..count){
            lists.add("")
        }
        return lists
    }

    fun changeRecommend(count:Int){
        recommend.value=count
    }
}