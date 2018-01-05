package com.battleshippark.cancelanimation

import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    private lateinit var rotationAnimator: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rotationAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f)
        with(rotationAnimator) {
            interpolator = LinearInterpolator()
            repeatCount = ObjectAnimator.INFINITE
            duration = 350
            start()
        }

        playButton.setOnClickListener { rotationAnimator.start() }
        pauseButton.setOnClickListener { rotationAnimator.pause() }
        cancelButton.setOnClickListener { rotationAnimator.cancel() }
        cancelClearButton.setOnClickListener {
            rotationAnimator.cancel()
            imageView.clearAnimation()
        }
        cancelPlayButton.setOnClickListener {
            rotationAnimator.cancel()
            rotationAnimator.start()
        }
        clearPlayButton.setOnClickListener {
            imageView.clearAnimation()
            rotationAnimator.start()
        }
    }
}
