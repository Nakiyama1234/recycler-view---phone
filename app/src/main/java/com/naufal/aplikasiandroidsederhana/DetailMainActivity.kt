package com.naufal.aplikasiandroidsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.naufal.aplikasiandroidsederhana.databinding.ActivityDetailMainBinding
import com.naufal.aplikasiandroidsederhana.databinding.ActivityProfileMainBinding

class DetailMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding = ActivityDetailMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val hp = intent.getParcelableExtra<HP>(EXTRA_HP) as HP
        initHp(hp)
    }

    private fun initHp(hp: HP) {
        binding.imageItemHp.setImageResource(hp.fotoHP)
        binding.itemName.text = hp.nameHP
        binding.itemDeskripsi.text = hp.deskripsi
        binding.goWeb.setOnClickListener{
            val goWeb = Intent()
            goWeb.action = Intent.ACTION_SEND
            goWeb.putExtra(
                Intent.EXTRA_TEXT, "Cek Di Web ${hp.nameHP}" +
                "${hp.urlHP}"
            )
            goWeb.type = "text/plain"
            startActivity(goWeb)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val EXTRA_HP: String = "EXTRA_HP"
    }
}