package com.jordilucas.coronanews.dto

data class CoronaDto(val id:Int, val site:String, val titulo:String, val url:String,
                     val dt_envio:String, val descricao:String, val image:String)