package com.battleshippark.sample.sharedelementtransitions

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_view_pager.*

/**
 */
class ViewPagerFragment3 : Fragment() {
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        position = arguments?.getInt("position") ?: 0

        postponeEnterTransition()
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager.adapter = PagerAdapter3(childFragmentManager)
        viewPager.currentItem = position
    }

    companion object {
        fun newInstance(position: Int): ViewPagerFragment3 {
            return ViewPagerFragment3().apply {
                arguments = Bundle().apply { putInt("position", position) }
            }
        }
    }
}
