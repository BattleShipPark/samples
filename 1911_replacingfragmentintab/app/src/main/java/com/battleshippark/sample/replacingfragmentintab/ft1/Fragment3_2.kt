package com.battleshippark.sample.replacingfragmentintab.ft1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.battleshippark.sample.replacingfragmentintab.LogLifecycleObserver
import com.battleshippark.sample.replacingfragmentintab.R

/**
 * A simple [Fragment] subclass.
 */
class Fragment3_2 : Fragment() {

    private var backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            fragmentManager?.popBackStack()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycle.addObserver(LogLifecycleObserver(this))

        (activity as? Container)?.sharedModel?.visiblePage
            ?.observe(
                viewLifecycleOwner,
                Observer(this::onVisiblePageChanged)
            )
    }

    private fun onVisiblePageChanged(position: Int) {
        if (position == 2) {
            activity?.onBackPressedDispatcher?.addCallback(
                viewLifecycleOwner,
                backPressedCallback
            )
        } else {
            backPressedCallback.remove()
        }
    }
}
