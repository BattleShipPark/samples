package com.battleshippark.sample.sharedelementtransitions

import android.content.Context
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
    private val sharedElementCallback = PagerSharedElementCallback()
    private lateinit var containerInteractor: MainContainerInteractor

    override fun onAttach(context: Context) {
        super.onAttach(context)

        containerInteractor = context as MainContainerInteractor
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        position = arguments?.getInt("position") ?: 0

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

        setEnterSharedElementCallback(sharedElementCallback)

        viewPager.adapter = PagerAdapter3(childFragmentManager) { position, view ->
            sharedElementCallback.setView(view)
            containerInteractor.selectedPosition = position
        }
        viewPager.currentItem = position
    }

    override fun onDestroyView() {
        sharedElementCallback.setView(null)
        super.onDestroyView()
    }

    companion object {
        fun newInstance(position: Int): ViewPagerFragment3 {
            return ViewPagerFragment3().apply {
                arguments = Bundle().apply { putInt("position", position) }
            }
        }
    }
}
