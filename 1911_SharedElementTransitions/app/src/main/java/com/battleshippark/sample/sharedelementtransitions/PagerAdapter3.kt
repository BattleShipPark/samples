package com.battleshippark.sample.sharedelementtransitions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter3(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val items = PhotoItems.generate()

    override fun getItem(position: Int): Fragment {
        return PhotoFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return items.count()
    }

}
