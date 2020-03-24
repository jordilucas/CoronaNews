package com.jordilucas.coronanews.service.retrofitInterface

import com.jordilucas.coronanews.dto.CoronaDto
import retrofit2.Call
import retrofit2.http.GET

interface Corona {
    @GET("api")
    fun coronaList(): Call<List<CoronaDto>>
}