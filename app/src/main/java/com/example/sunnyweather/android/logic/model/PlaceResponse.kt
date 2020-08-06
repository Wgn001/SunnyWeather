package com.example.sunnyweather.android.logic.model


data class PlaceResponse(val status:String,val places :List<Place>)

data class Place(val name: String,val location:Location)

data class Location(val lng:String,val lat:String)