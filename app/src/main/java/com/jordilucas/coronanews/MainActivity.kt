package com.jordilucas.coronanews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.jordilucas.coronanews.adapter.CoronaAdapter
import com.jordilucas.coronanews.dto.CoronaDto
import com.jordilucas.coronanews.extensions.fromJson
import com.jordilucas.coronanews.extensions.toJson
import com.jordilucas.coronanews.service.RetrofitInitializer
import kotlinx.android.synthetic.main.corona_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.corona_list)

    }

    override fun onResume() {
        super.onResume()

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.setHasFixedSize(true)

        service()

    }

    fun service(){
        val service = RetrofitInitializer.coronaService().coronaList()
        service.enqueue(object : Callback<List<CoronaDto>> {
            override fun onResponse(call: Call<List<CoronaDto>>, response: Response<List<CoronaDto>>) {
                recycler_view.adapter = response.body()?.let { CoronaAdapter(it) }
            }

            override fun onFailure(call: Call<List<CoronaDto>>, t: Throwable) {
                Log.d("onError", t.message.toString())
            }
            
        })
    }

}
