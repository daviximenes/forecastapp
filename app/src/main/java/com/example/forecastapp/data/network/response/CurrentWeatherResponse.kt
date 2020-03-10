package com.example.forecastapp.data.network.response

import com.example.forecastapp.data.db.entity.Current
import com.example.forecastapp.data.db.entity.Location
import com.example.forecastapp.data.db.entity.Request


data class CurrentWeatherResponse(
    val current: Current,
    val location: Location,
    val request: Request
)