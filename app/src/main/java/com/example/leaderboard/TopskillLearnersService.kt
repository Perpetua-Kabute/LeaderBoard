package com.example.leaderboard


import com.example.leaderboard.ui.main.Posts
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface TopskillLearnersService {

    @GET("/api/hours")
    fun getTopLearners(): Call<List<TopLearners>>

    @GET("/api/skilliq")
    fun getTopSkillIq(): Call<List<TopSkillIq>>

//    @POST("")
//    fun postData(
//        @Field("name")name:String
//    )
//    @POST("")
//    fun postData2(
//        @Body data: Posts
//    ): Call<Posts>

}