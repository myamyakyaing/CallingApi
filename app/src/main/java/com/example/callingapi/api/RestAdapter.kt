package com.example.callingapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestAdapter {
    const val URL_BASE = "https://jsonplaceholder.typicode.com"
    private var retrofit: Retrofit? = null
    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(HttpClientProvider.provideOkHttpClient())
                .build()
        }
        return retrofit!!
    }
}
