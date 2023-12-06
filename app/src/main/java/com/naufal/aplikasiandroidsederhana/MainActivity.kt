package com.naufal.aplikasiandroidsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    private fun getListHP(): ArrayList<HP> {
        val namaHP = resources.getStringArray(R.array.nama_hp)
        val deskripsiHP = resources.getStringArray(R.array.deskripsi_hp)
        val fotoHP = resources.obtainTypedArray(R.array.data_gambar)
        val urlHP = resources.getStringArray(R.array.url_phone)
        val listHP = ArrayList<HP>()
        for (i in namaHP.indices) {
            val hp = HP(namaHP[i], deskripsiHP[i], urlHP[i], fotoHP.getResourceId(i, -1))
            listHP.add(hp)
        }
        return listHP
    }

    private fun showRecycelerlist() {
        rvHP.layoutManager = LinearLayoutManager(this)
        val listHpAdapter = ListHpAdapter(list)
        rvHP.adapter = listHpAdapter

        listHpAdapter.setOnItemClickCallback(object : ListHpAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HP) {
                showSelectedHp(data)
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        when (item.itemId){
            R.id.my_profile -> {
                val moveIntent = Intent(this@MainActivity, ProfileMainActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedHp(hp: HP) {
        Toast.makeText(this, "Kamu Memilih " + hp.nameHP, Toast.LENGTH_SHORT).show()
    }


}