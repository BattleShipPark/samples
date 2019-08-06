package com.battleshippark.statusbar

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
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

        transparent1_code.setOnClickListener {
            resetWindowFlags()

            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )

            findViewById<View>(android.R.id.content).requestLayout() // you don't need this if you run above codes before setContentView()
        }

        transparent2_code.setOnClickListener {
            resetWindowFlags()
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, 0)

            window?.decorView?.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT

            findViewById<View>(android.R.id.content).requestLayout() // you don't need this if you run above codes before setContentView()
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
