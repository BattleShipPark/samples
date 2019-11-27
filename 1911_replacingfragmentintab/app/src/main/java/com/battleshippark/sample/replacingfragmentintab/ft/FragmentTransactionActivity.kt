package com.battleshippark.sample.replacingfragmentintab.ft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.battleshippark.sample.replacingfragmentintab.R
import kotlinx.android.synthetic.main.activity_fragment_transaction.*

class FragmentTransactionActivity : AppCompatActivity() {
    private var fragment1: Fragment? = null
    private var fragment2: Fragment? = null
    private var fragment3: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transaction)

        tab1.setOnClickListener {
            supportFragmentManager.beginTransaction().run {
                if (fragment1 == null) {
                    fragment1 = Fragment1()
                    add(R.id.fragment_container, fragment1!!)
                } else {
                    show(fragment1!!)
                }
                if (fragment2 != null) {
                    hide(fragment2!!)
                }
                if (fragment3 != null) {
                    hide(fragment3!!)
                }
                commit()
            }
        }

        tab2.setOnClickListener {
            supportFragmentManager.beginTransaction().run {
                if (fragment2 == null) {
                    fragment2 = Fragment2()
                    add(R.id.fragment_container, fragment2!!)
                } else {
                    show(fragment2!!)
                }
                if (fragment1 != null) {
                    hide(fragment1!!)
                }
                if (fragment3 != null) {
                    hide(fragment3!!)
                }
                commit()
            }
        }

        tab3.setOnClickListener {
            supportFragmentManager.beginTransaction().run {
                if (fragment3 == null) {
                    fragment3 = Fragment3()
                    add(R.id.fragment_container, fragment3!!)
                } else {
                    show(fragment3!!)
                }
                if (fragment1 != null) {
                    hide(fragment1!!)
                }
                if (fragment2 != null) {
                    hide(fragment2!!)
                }
                commit()
            }
        }
    }
}
