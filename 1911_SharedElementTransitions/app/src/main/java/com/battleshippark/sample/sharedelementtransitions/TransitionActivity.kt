package com.battleshippark.sample.sharedelementtransitions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, PhotoListFragment()).commit()
    }
}
