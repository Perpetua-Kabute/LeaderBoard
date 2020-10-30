package com.example.leaderboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.leaderboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main )
        Log.i("Main Activity", "onCreate called")
        val SPLASH_TIME_OUT:Long = 3000

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

    override fun onStart() {
        super.onStart()
        Log.i("Main Activity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Main Activity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Main Activity", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Main Activity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Main Activity", "onDestroy called")
    }
}