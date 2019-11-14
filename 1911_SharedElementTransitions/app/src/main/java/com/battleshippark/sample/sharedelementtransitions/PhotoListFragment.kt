package com.battleshippark.sample.sharedelementtransitions


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_photo_list.*

/**
 */
class PhotoListFragment : Fragment() {
    private val sharedElementCallback = ListSharedElementCallback()
    private lateinit var containerInteractor: MainContainerInteractor

    override fun onAttach(context: Context) {
        super.onAttach(context)

        containerInteractor = context as MainContainerInteractor
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val screen = arguments?.getInt("screen") ?: 1

        setExitSharedElementCallback(sharedElementCallback)

        listView.adapter = PhotoListAdapter { itemView, position ->
            fragmentManager ?: return@PhotoListAdapter

            val fragment = when (screen) {
                1 -> ViewPagerFragment.newInstance(position)
                2 -> ViewPagerFragment2()
                else -> ViewPagerFragment3.newInstance(position)
            }

            sharedElementCallback.setView(null)

            fragmentManager!!.beginTransaction()
                .addSharedElement(itemView, itemView.transitionName)
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        (listView.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(0, -1)

        listView.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(
                v: View?,
                left: Int,
                top: Int,
                right: Int,
                bottom: Int,
                oldLeft: Int,
                oldTop: Int,
                oldRight: Int,
                oldBottom: Int
            ) {
                listView.removeOnLayoutChangeListener(this)
                val lm = (listView.layoutManager as? GridLayoutManager) ?: return
                val view = lm.findViewByPosition(containerInteractor.selectedPosition)
                    ?.findViewById<View>(R.id.imageView) ?: return
                sharedElementCallback.setView(view)
            }
        })
    }

    companion object {
        fun newInstance(screen: Int): PhotoListFragment {
            return PhotoListFragment().apply {
                arguments = Bundle().apply { putInt("screen", screen) }
            }
        }
    }
}
