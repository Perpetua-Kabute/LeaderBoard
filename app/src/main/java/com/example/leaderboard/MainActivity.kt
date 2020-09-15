package com.example.leaderboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val SPLASH_TIME_OUT:Long = 9000

       // window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //actionBar?.hide()
        Looper.myLooper()?.let {
        Handler(it).postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,LeaderBoard::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
        }

    }
}