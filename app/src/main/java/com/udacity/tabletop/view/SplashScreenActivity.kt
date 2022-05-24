package com.udacity.tabletop.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.udacity.tabletop.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        // Send user to MainActivity as soon as this activity loads
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        // remove this activity from the stack
        finish()
    }
}