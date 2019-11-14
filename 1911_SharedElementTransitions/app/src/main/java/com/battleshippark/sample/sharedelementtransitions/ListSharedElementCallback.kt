package com.battleshippark.sample.sharedelementtransitions

import android.view.View
import androidx.core.app.SharedElementCallback

class ListSharedElementCallback : SharedElementCallback() {
    private var view: View? = null

    override fun onMapSharedElements(
        names: MutableList<String>?,
        sharedElements: MutableMap<String, View>?
    ) {
        if (view != null && names != null && sharedElements != null) {
            sharedElements[names[0]] = view!!
        }
    }

    fun setView(view: View?) {
        this.view = view
    }
}