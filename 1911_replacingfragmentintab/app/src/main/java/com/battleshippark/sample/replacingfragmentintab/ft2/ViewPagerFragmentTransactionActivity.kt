package com.battleshippark.sample.replacingfragmentintab.ft2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.battleshippark.sample.replacingfragmentintab.R
import com.battleshippark.sample.replacingfragmentintab.ft1.Fragment1
import com.battleshippark.sample.replacingfragmentintab.ft1.Fragment2
import com.battleshippark.sample.replacingfragmentintab.ft1.Fragment3
import kotlinx.android.synthetic.main.activity_fragment_transaction.tab1
import kotlinx.android.synthetic.main.activity_fragment_transaction.tab2
import kotlinx.android.synthetic.main.activity_fragment_transaction.tab3
import kotlinx.android.synthetic.main.activity_view_pager_fragment_transaction.*

class ViewPagerFragmentTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_fragment_transaction)

        view_pager.adapter = Adapter(supportFragmentManager)
        tab1.setOnClickListener {
            view_pager.currentItem = 0
        }

        tab2.setOnClickListener {
            view_pager.currentItem = 1
        }

        tab3.setOnClickListener {
            view_pager.currentItem = 2
        }
    }

    private class Adapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val fragmentList = mutableListOf<Fragment?>(null, null, null)

        override fun getItem(position: Int): Fragment {
            if (fragmentList[position] == null) {
                fragmentList[position] = createFragment(position)
            }

            return fragmentList[position]!!
        }

        private fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> Fragment1()
                1 -> Fragment2()
                2 -> Fragment3()
                else -> throw IllegalArgumentException()
            }
        }

        override fun getCount() = 3
    }
}
