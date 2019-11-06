package com.battleshippark.sample.sharedelementtransitions


import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_photo.*
import kotlinx.android.synthetic.main.list_item_photo_list.view.*

private const val ARG_POSITION = "position"

/**
 */
class PhotoFragment : Fragment() {
    private var position: Int = 0
    private val items = PhotoItems.generate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG_POSITION)
        }

        postponeEnterTransition()
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load(items[position].imageUrl)
            .dontTransform()
            .override(512, 512)
            .into(view.imageView)

        imageView.transitionName = "TN${position}"
        textView.text = String.format(
            "URL: %s\nWidth: %d, Height: %d",
            items[position].webPageUrl,
            items[position].width,
            items[position].height
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            PhotoFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_POSITION, position)
                }
            }
    }
}
