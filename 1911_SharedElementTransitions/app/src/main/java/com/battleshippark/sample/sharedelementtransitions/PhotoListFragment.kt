package com.battleshippark.sample.sharedelementtransitions


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_photo_list.*

/**
 */
class PhotoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView.adapter = PhotoListAdapter(
            View.OnClickListener {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, ViewPagerFragment(), "VP")
                    ?.addToBackStack("VP")
                    ?.commit()
            })
    }
}
