package com.joabesantana.thedogceoapiapp.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDogClient {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://api.thedogapi.com"

        private fun getRetrofitInstance(): Retrofit {
            if (!Companion::INSTANCE.isInitialized) {
                val http = OkHttpClient.Builder()
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL).client(http.build())
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return INSTANCE
        }

        fun <T> createService(service: Class<T>): T {
            return getRetrofitInstance().create(service)
        }
    }
}