package com.shusharin.motionlayoutstudy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

    override fun onStart() {
        super.onStart()
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        motionLayout.setTransitionListener(object : TransitionAdapter(){

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                super.onTransitionCompleted(motionLayout, currentId)
                when(currentId) {
                    R.id.offScreenLike,
                    R.id.offScreenPass -> {
                        motionLayout?.progress = 0f
                        motionLayout?.setTransition(R.id.rest, R.id.like)
                    }
                }
            }
        })

    }
}