package com.example.ravijayaraman.animation_demo

import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.*
import android.view.View.TRANSLATION_Y
import android.view.View.TRANSLATION_X
import android.view.animation.AccelerateInterpolator


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstFunction()
    }

    private fun firstFunction() {
        print("Hello")
        val mTextView = findViewById(R.id.tvTextView) as? TextView
        mTextView?.text = "Hello Ravi!!!"

//        val valueAnimator = ValueAnimator.ofFloat(0f, 360f)
//        valueAnimator.repeatCount = ValueAnimator.INFINITE

//        //Animations for linear Y axis
//        valueAnimator.addUpdateListener {
//            val value = it.animatedValue as Float
//            mTextView?.translationY = value
//        }
//
//        valueAnimator.interpolator = LinearInterpolator()
//        valueAnimator.duration = 5000
//
//        valueAnimator.start()

//        //Animation for rotation on axis
//        valueAnimator.addUpdateListener {
//            val value = it.animatedValue as Float
//            mTextView?.rotation = value
//        }
//
//        valueAnimator.interpolator = LinearInterpolator()
//        valueAnimator.duration = 2000
//        valueAnimator.start()

        //Animation for the acceleration
        val valueAnimator = ValueAnimator.ofFloat(0f, -windowManager.defaultDisplay.height.toFloat()/4)
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            mTextView?.translationY = value
        }

        valueAnimator.interpolator = AccelerateInterpolator(1.5f)
        valueAnimator.duration = 1000
        valueAnimator.repeatMode = ValueAnimator.REVERSE
        valueAnimator.repeatCount = ValueAnimator.INFINITE

        valueAnimator.start()
    }
}
