package com.vitusortner.patterns.ui.pins

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vitusortner.patterns.R
import com.vitusortner.patterns.networking.model.Image
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cell_pin.view.*

class _PinsAdaper : RecyclerView.Adapter<ViewHolder>() {

    var items: List<Image> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_pin, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        val url = item.url
        val width = item.width
        val height = item.height

        if (url.isBlank()) return

        Picasso.get()
            .load(url)
//            .fit()
//            .centerCrop()
            .into(holder.containerView.imageView)
    }

}

class PinsAdapter : ListAdapter<Image, ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_pin, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = getItem(position).url

        if (url.isBlank()) return

        Picasso.get()
            .load(url)
            .into(holder.itemView.imageView)
    }

}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }
}

class ViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer
