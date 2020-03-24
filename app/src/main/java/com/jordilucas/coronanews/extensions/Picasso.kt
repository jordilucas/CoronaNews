package com.jordilucas.coronanews.extensions

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.jordilucas.coronanews.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import java.lang.Exception

fun ImageView.loadUrl(url: String?, progress: ProgressBar? = null) {
    if(url == null || url.trim().isEmpty()){
        //Picasso.get().load(url).fit().centerCrop().placeholder(R.drawable.not_found).into(this)
        setImageBitmap(
            BitmapFactory.decodeResource(context.getResources(),
            R.drawable.not_found))
        return
    }
    if(progress == null){
        Picasso.get().load(url).fit().centerCrop().placeholder(R.drawable.not_found).into(this)
    }
    else{
        progress.visibility = View.VISIBLE
        Picasso.get().load(url).fit().centerCrop().placeholder(R.drawable.not_found).into(this, object : Callback{
            override fun onSuccess() {
                progress.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                progress.visibility = View.GONE
            }
        })
    }
}