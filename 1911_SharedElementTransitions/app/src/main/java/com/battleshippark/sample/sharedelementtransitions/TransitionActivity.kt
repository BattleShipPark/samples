package com.battleshippark.sample.sharedelementtransitions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        val screen = intent.getIntExtra("screen", 1)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, PhotoListFragment.newInstance(screen)).commit()
    }
}
