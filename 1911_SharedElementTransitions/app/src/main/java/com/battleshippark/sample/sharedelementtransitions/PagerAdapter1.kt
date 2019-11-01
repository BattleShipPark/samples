package com.battleshippark.sample.sharedelementtransitions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_photo_list.view.*

class PagerAdapter1 : PagerAdapter() {
    private val items = PhotoItems.generate()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.list_item_photo, container, false)
        Glide.with(view).load(items[position].imageUrl).into(view.imageView)

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as View
    }

    override fun getCount(): Int {
        return items.count()
    }

}
