package com.joabesantana.retrofit_client.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        private lateinit var INSTANCE: Retrofit

        private fun getRetrofitInstance(baseUrl: String): Retrofit {
            if (!Companion::INSTANCE.isInitialized) {
                val http = OkHttpClient.Builder()
                INSTANCE = Retrofit.Builder().baseUrl(baseUrl).client(http.build())
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return INSTANCE
        }

        fun <T> createService(baseUrl: String, service: Class<T>): T {
            return getRetrofitInstance(baseUrl).create(service)
        }
    }
}