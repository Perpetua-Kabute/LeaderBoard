package com.example.leaderboard

import android.telecom.Call
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface TopskillLearnersService {

    @GET("/api/hours")
    fun getTopLearners():Deferred<List<TopLearners>>
}