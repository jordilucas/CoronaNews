package com.jordilucas.coronanews.service

import com.jordilucas.coronanews.dto.CoronaDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://covid.migre.me/api")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun coronaService() = retrofit.create(CoronaDto::class.java)

}