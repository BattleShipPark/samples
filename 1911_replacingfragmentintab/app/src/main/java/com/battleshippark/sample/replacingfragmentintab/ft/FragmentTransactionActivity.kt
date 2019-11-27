package com.battleshippark.sample.replacingfragmentintab.ft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.battleshippark.sample.replacingfragmentintab.R
import kotlinx.android.synthetic.main.activity_fragment_transaction.*

class FragmentTransactionActivity : AppCompatActivity() {
    private val fragment1: Fragment by lazy { Fragment1() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transaction)

        tab1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment1)
                .commit()
        }
    }
}
