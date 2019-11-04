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

        val screen = arguments?.getInt("screen") ?: 1

        listView.adapter = PhotoListAdapter { itemView, position ->
            itemView.transitionName = "TN$position"

            fragmentManager ?: return@PhotoListAdapter

            val fragment = if (screen == 1) {
                ViewPagerFragment()
            } else {
                ViewPagerFragment2()
            }
            fragmentManager!!.beginTransaction()
                .addSharedElement(itemView, itemView.transitionName)
                .replace(R.id.fragment_container, fragment, "VP")
                .addToBackStack("VP")
                .commit()
        }
    }

    companion object {
        fun newInstance(screen: Int): PhotoListFragment {
            return PhotoListFragment().apply {
                arguments = Bundle().apply { putInt("screen", screen) }
            }
        }
    }
}
