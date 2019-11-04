package com.battleshippark.sample.sharedelementtransitions

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.list_item_photo.view.*
import kotlinx.android.synthetic.main.list_item_photo_list.view.imageView

class PagerAdapter2(private val fragment: Fragment) : PagerAdapter() {
    private val items = PhotoItems.generate()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.list_item_photo, container, false)

        container.addView(view)

        container.postDelayed({
            Glide.with(view).load(items[position].imageUrl)
                .addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        fragment.startPostponedEnterTransition()
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        fragment.startPostponedEnterTransition()
                        return false
                    }
                })
                .into(view.imageView)
        }, 100)

        view.imageView.transitionName = "TN${position}"
        view.textView.text = String.format(
            "URL: %s\nWidth: %d, Height: %d",
            items[position].webPageUrl,
            items[position].width,
            items[position].height
        )

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
