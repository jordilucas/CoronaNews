package com.jordilucas.coronanews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jordilucas.coronanews.dto.CoronaDto
import com.jordilucas.coronanews.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        service()
    }

    fun service(){
        val service = RetrofitInitializer.coronaService().coronaList()
        service.enqueue(object : Callback<List<CoronaDto>> {
            override fun onResponse(call: Call<List<CoronaDto>>, response: Response<List<CoronaDto>>) {

                Log.d("onResponse", response.body().toString())

            }

            override fun onFailure(call: Call<List<CoronaDto>>, t: Throwable) {
                Log.d("onError", t.message.toString())
            }
            
        })
    }

}
