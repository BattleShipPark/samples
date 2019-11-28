package com.battleshippark.sample.replacingfragmentintab

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.battleshippark.sample.replacingfragmentintab.ft.FragmentTransactionActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickFragmentTransaction1(view: View) {
        startActivity(Intent(this, FragmentTransactionActivity::class.java))
    }

    fun onClickFragmentTransaction2(view: View) {
    }
}
