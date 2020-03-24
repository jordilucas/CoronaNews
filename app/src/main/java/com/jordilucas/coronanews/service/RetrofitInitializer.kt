package com.jordilucas.coronanews.service

import com.jordilucas.coronanews.dto.CoronaDto
import com.jordilucas.coronanews.service.retrofitInterface.Corona
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://covid.migre.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun coronaService() = retrofit.create(Corona::class.java)

}