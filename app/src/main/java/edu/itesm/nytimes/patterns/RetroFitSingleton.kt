package edu.itesm.nytimes.patterns

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitSingleton {
    private val BASE_URL = "https://api.nytimes.com/svc/books/v3/lists/current/"

    fun getRetroFit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

fun main(args : Array<String>){
    println(RetroFitSingleton.toString())
    println(RetroFitSingleton.toString())
}