package com.example.forecastapp.data

import com.example.forecastapp.data.db.entity.Current
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "c9b3de4ae44d05b3054159dba9d1759a"
//http://api.weatherstack.com/current?access_key=c9b3de4ae44d05b3054159dba9d1759a&query=New%20York
interface ApiService {
    @GET(value = "current")
    fun getCurrentWeather(
        @Query(value = "query") location: String,
        @Query(value = "lang") language: String = "en"
    ): Deferred<Current>

    companion object {
        operator fun invoke(): ApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}