package com.naufal.aplikasiandroidsederhana

import android.content.Intent
import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListHpAdapter(private val listHP: ArrayList<HP>) :
    RecyclerView.Adapter<ListHpAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: HP)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.image_item_hp)
        val namaHP: TextView = itemView.findViewById(R.id.item_name)
        val deskripsi: TextView = itemView.findViewById(R.id.item_deskripsi)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hp, parent, false)
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val HP = listHP[position]
        holder.imgPhoto.setImageResource(HP.fotoHP)
        holder.namaHP.text = HP.nameHP
        holder.deskripsi.text = HP.deskripsi
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Page HP " + listHP[holder.adapterPosition].nameHP,
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHP[holder.adapterPosition])
            val intent = Intent(it.context, DetailMainActivity::class.java)
            intent.putExtra(DetailMainActivity.EXTRA_HP, HP)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listHP.size

}
