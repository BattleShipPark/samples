package com.battleshippark.statusbar

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var defaultFlag: Int = 0
    private var defaultSystemUiVisibility: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defaultFlag = window.attributes.flags
        defaultSystemUiVisibility = window?.decorView?.systemUiVisibility ?: 0

        color_code.setOnClickListener {
            runBlock {
                window.statusBarColor = Color.RED
            }
        }

        color_theme.setOnClickListener {
            startActivity(Intent(this, ColorActivity::class.java))
        }

        translucent_code.setOnClickListener {
            runBlock {
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            }
        }

        translucent_theme.setOnClickListener {
            startActivity(Intent(this, TranslucentActivity::class.java))
        }

        transparent1_code.setOnClickListener {
            runBlock {
                window.setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )
            }
        }

        transparent2_code.setOnClickListener {
            runBlock {
                window?.decorView?.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                window.statusBarColor = Color.TRANSPARENT
            }
        }

        transparent3_code.setOnClickListener {
            runBlock {
                window?.decorView?.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = Color.TRANSPARENT
            }
        }
    }

    private fun runBlock(block: Activity.() -> Unit) {
        reset()

        block()

        findViewById<View>(android.R.id.content).requestLayout() // you don't need this if you run above codes before setContentView()

    }

    private fun reset() {
        window.attributes.flags = defaultFlag
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, 0)
        window?.decorView?.systemUiVisibility = defaultSystemUiVisibility
        setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
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
