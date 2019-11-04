package com.battleshippark.sample.sharedelementtransitions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_photo_list.view.*

class PhotoListAdapter(private val onClickItem: (View, Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = PhotoItems.generate()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_photo_list,
                parent,
                false
            )
        ) {}
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(items[position].imageUrl).into(holder.itemView.imageView)

        holder.itemView.imageView.setOnClickListener {
            onClickItem(it, position)
        }
    }
}
