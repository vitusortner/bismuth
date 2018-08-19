package com.vitusortner.patterns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vitusortner.patterns.networking.model.I
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cell_pin.view.imageView

class PinsAdapter : RecyclerView.Adapter<ViewHolder>() {

    var items: List<I> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_pin, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = items[position].image.original.url

        if (url.isNotBlank()) {
            Picasso.get()
                .load(url)
                .into(holder.itemView.imageView)
        }
    }

}

class ViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer