package com.naufal.aplikasiandroidsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHP: RecyclerView
    private val list = ArrayList<HP>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHP = findViewById(R.id.rv_hp)
        rvHP.setHasFixedSize(true)

        list.addAll(getListHP())
        showRecycelerlist()
    }
    private fun getListHP(): ArrayList<HP> {
        val namaHP = resources.getStringArray(R.array.nama_hp)
        val deskripsiHP = resources.getStringArray(R.array.deskripsi_hp)
        val fotoHP = resources.obtainTypedArray(R.array.data_gambar)
        val listHP = ArrayList<HP>()
        for (i in namaHP.indices){
            val hp = HP(namaHP[i], deskripsiHP[i], fotoHP.getResourceId(i, -1))
        }
        return listHP
    }
    private fun showRecycelerlist() {
        rvHP.layoutManager = LinearLayoutManager(this)
        val listHpAdapter = ListHpAdapter(list)
        rvHP.adapter = listHpAdapter
    }
}