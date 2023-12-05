package com.naufal.aplikasiandroidsederhana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListHpAdapter(private val listHP: ArrayList<HP>) : RecyclerView.Adapter<ListHpAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.image_item_hp)
        val namaHP: TextView = itemView.findViewById(R.id.item_name)
        val deskripsi: TextView = itemView.findViewById(R.id.item_deskripsi)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hp, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nameHP, deskirpsi, imgPhoto) = listHP[position]
        holder.imgPhoto.setImageResource(imgPhoto)
        holder.namaHP.text = nameHP
        holder.deskripsi.text = deskirpsi

    }

    override fun getItemCount(): Int = listHP.size

    }
