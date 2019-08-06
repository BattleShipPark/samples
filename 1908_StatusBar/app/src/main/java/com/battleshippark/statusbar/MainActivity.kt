package com.battleshippark.statusbar

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var defaultFlag: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defaultFlag = window.attributes.flags

        color_code.setOnClickListener {
            resetWindowFlags()
            window.statusBarColor = Color.RED
        }

        color_theme.setOnClickListener {
            startActivity(Intent(this, ColorActivity::class.java))
        }

        translucent_code.setOnClickListener {
            resetWindowFlags()
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }

        translucent_theme.setOnClickListener {
            startActivity(Intent(this, TranslucentActivity::class.java))
        }
    }

    private fun resetWindowFlags() {
        window.attributes.flags = defaultFlag
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window ?: return
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}
