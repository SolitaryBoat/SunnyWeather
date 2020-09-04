package com.sunnyweather.android.logic.dao

import android.content.Context
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.Place

object PlaceDao {
    fun savePlace(place: Place){
        val shared=sharedPreferences().edit()
        shared.apply {
            putString("place",Gson().toJson(place))
        }
        shared.apply()
    }
    
    fun getSavedPlace():Place{
        val placeJson= sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }

    fun isPlaceSaved()= sharedPreferences().contains("place")

    private fun sharedPreferences()=SunnyWeatherApplication.context.
                                    getSharedPreferences("sunny_weather",Context.MODE_PRIVATE)
}