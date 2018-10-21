package com.modic.ignite.ui.sharewall

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.modic.ignite.R
import kotlinx.android.synthetic.main.share_list_item.view.*

class ShareWallAdapter : RecyclerView.Adapter<ShareWallAdapter.ViewHolder>(){

    var items: List<String> = emptyList()

    fun loadItems(newItems: List<String>){
        items = newItems
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.share_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.share_text.text = items.get(position)
    }
}