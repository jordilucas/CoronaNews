package com.jordilucas.coronanews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jordilucas.coronanews.R
import com.jordilucas.coronanews.dto.CoronaDto
import kotlinx.android.synthetic.main.item_list.view.*

class CoronaAdapter(private val corona: List<CoronaDto>) : RecyclerView.Adapter<CoronaAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount() = corona.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        val corona = corona[position]
        with(view){
            txt_title.text = corona.titulo
            txt_fonte.text = corona.site
            txt_date.text = corona.dt_envio
        }
    }
}