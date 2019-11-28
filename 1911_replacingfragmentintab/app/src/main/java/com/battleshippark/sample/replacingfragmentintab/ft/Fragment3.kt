package com.battleshippark.sample.replacingfragmentintab.ft


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.battleshippark.sample.replacingfragmentintab.LogLifecycleObserver
import com.battleshippark.sample.replacingfragmentintab.R

/**
 * A simple [Fragment] subclass.
 */
class Fragment3 : Fragment(), Fragment3_1.Container {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycle.addObserver(LogLifecycleObserver(this))
    }

    override fun openPage() {
        childFragmentManager.beginTransaction()
            .addToBackStack(null)
            .setCustomAnimations(android.R.anim.slide_in_left, 0, 0, android.R.anim.slide_out_right)
            .replace(R.id.fragment_container, Fragment3_2())
            .commit()
    }
}
