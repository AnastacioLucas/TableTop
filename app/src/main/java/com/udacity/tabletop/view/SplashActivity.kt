package com.udacity.tabletop.view

import android.app.ActivityOptions.makeSceneTransitionAnimation
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.udacity.tabletop.R

class SplashActivity : AppCompatActivity(),
    MotionLayout.TransitionListener {

    lateinit var motionLayout: MotionLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        motionLayout = findViewById(R.id.ml_splash_screen_area)
        motionLayout.addTransitionListener(this)

        Handler().postDelayed({
            motionLayout.transitionToEnd()
        },200)
    }

    override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {
    }

    override fun onTransitionChange(
        motionLayout: MotionLayout?,
        startId: Int,
        endId: Int,
        progress: Float
    ) {
    }

    override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent, makeSceneTransitionAnimation(this).toBundle())

        Handler().postDelayed({
            finishAfterTransition()
        },500)
    }

    override fun onTransitionTrigger(
        motionLayout: MotionLayout?,
        triggerId: Int,
        positive: Boolean,
        progress: Float
    ) {
    }
}