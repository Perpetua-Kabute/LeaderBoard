package com.example.leaderboard


import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface TopskillLearnersService {

    @GET("/api/hours")
    fun getTopLearners(): Call<List<TopLearners>>

    @GET("/api/skilliq")
    fun getTopSkillIq(): Call<List<TopSkillIq>>
}