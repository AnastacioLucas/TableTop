package com.udacity.tabletop.view

import android.app.ActivityOptions.makeSceneTransitionAnimation
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.udacity.tabletop.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val backgroundImg : ImageView = findViewById(R.id.iv_logo)
        val sideAnimation = AnimationUtils.loadAnimation(this,R.anim.slide)
        backgroundImg.startAnimation(sideAnimation)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent, makeSceneTransitionAnimation(this).toBundle())
            finishAfterTransition()
        },2000)
    }
}