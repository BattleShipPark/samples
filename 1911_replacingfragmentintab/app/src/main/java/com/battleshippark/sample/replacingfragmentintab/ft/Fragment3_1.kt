package com.battleshippark.sample.replacingfragmentintab.ft


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.battleshippark.sample.replacingfragmentintab.LogLifecycleObserver
import com.battleshippark.sample.replacingfragmentintab.R
import kotlinx.android.synthetic.main.fragment_fragment3_1.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment3_1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycle.addObserver(LogLifecycleObserver(this))

        button.setOnClickListener {
            (parentFragment as? Container)?.openPage()
        }
    }

    interface Container {
        fun openPage()
    }
}
