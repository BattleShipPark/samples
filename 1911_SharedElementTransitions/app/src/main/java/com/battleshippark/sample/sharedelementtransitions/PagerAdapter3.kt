package com.battleshippark.sample.sharedelementtransitions

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter3(
    fragmentManager: FragmentManager,
    private val onPrimaryItem: (Int, View?) -> Unit
) : FragmentStatePagerAdapter(fragmentManager) {

    private val items = PhotoItems.generate()

    override fun getItem(position: Int): Fragment {
        return PhotoFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return items.count()
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
        val rootView = (`object` as Fragment).view ?: return

        val view = rootView.findViewById<View>(R.id.imageView)
        onPrimaryItem(position, view)
    }
}
