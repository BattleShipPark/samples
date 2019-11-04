package com.battleshippark.sample.sharedelementtransitions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            startActivity(
                Intent(this, TransitionActivity::class.java).apply {
                    putExtra("screen", 1)
                }
            )
        }

        button2.setOnClickListener {
            startActivity(
                Intent(this, TransitionActivity::class.java).apply {
                    putExtra("screen", 2)
                }
            )
        }
    }
}
