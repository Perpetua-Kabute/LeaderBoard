package com.example.leaderboard


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceBuilder {
    val baseurl = "https://gadsapi.herokuapp.com"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service:TopskillLearnersService = retrofit.create(TopskillLearnersService::class.java)
}
