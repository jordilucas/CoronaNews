package com.jordilucas.coronanews.adapter


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jordilucas.coronanews.R
import com.jordilucas.coronanews.WebViewActivity
import com.jordilucas.coronanews.dto.CoronaDto
import com.jordilucas.coronanews.extensions.loadUrl
import kotlinx.android.synthetic.main.item_list.view.*
import java.text.SimpleDateFormat


class CoronaAdapter(private val corona: List<CoronaDto>) : RecyclerView.Adapter<CoronaAdapter.ViewHolder>(),
    View.OnClickListener {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    private val url:String = ""
    lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        context = parent.context
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        val corona = corona[position]
        with(view){
            txt_title.text = corona.titulo
            txt_fonte.text = corona.site
            val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
            val output = formatter.format(parser.parse(corona.dt_envio))
            txt_date.text = output
            imageUrl.loadUrl(corona.imagem, progress)

        }

        view.setOnClickListener(this)

    }

    override fun getItemCount() = corona.size
    override fun onClick(v: View?) {
        val intent:Intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra("url", url)
        context.startActivity(intent)
    }


}