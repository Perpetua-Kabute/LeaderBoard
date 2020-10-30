package com.example.leaderboard

import com.google.gson.annotations.SerializedName


data class TopLearners(

    val name:String,
    val hours:Int,
    val country:String,
    val badgeUrl:String
)
