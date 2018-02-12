package com.battleshippark.finalinlibrary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.battleshippark.mylibrary.SubActivity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, SubActivity::class.java))
    }
}
