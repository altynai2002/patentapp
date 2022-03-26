package com.pro.patentapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.pro.patentapp.databinding.ItemRecyclerBinding

internal class ImageListAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val itemList: Array<String>?
) : ArrayAdapter<ImageListAdapter.ItemViewHolder>(context, resource) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var itemBinding: ItemRecyclerBinding

    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        val holder: ItemViewHolder

        if (convertView == null) {
            itemBinding = ItemRecyclerBinding.inflate(inflater)
            convertView = itemBinding.root
            holder = ItemViewHolder()
            holder.name = itemBinding.textView
            holder.icon = itemBinding.icon
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemViewHolder
        }
        holder.name!!.text = this.itemList!![position]

        when (position) {
            0 -> holder.icon!!.setImageResource(R.drawable.icon0)
            1 -> holder.icon!!.setImageResource(R.drawable.collectibles)
            2 -> holder.icon!!.setImageResource(R.drawable.puzzle)
            3 -> holder.icon!!.setImageResource(R.drawable.briefcase)
            4 -> holder.icon!!.setImageResource(R.drawable.idea)
            5 -> holder.icon!!.setImageResource(R.drawable.organization)
            6 -> holder.icon!!.setImageResource(R.drawable.scroll)
            7 -> holder.icon!!.setImageResource(R.drawable.services)
            8 -> holder.icon!!.setImageResource(R.drawable.share)
            9 -> holder.icon!!.setImageResource(R.drawable.toolbox)
            10 -> holder.icon!!.setImageResource(R.drawable.news)
            11 -> holder.icon!!.setImageResource(R.drawable.recurring)
        }
        return convertView
    }

    internal class ItemViewHolder {
        var name: TextView? = null
        var icon: ImageView? = null
    }
}
