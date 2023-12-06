package com.naufal.aplikasiandroidsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.naufal.aplikasiandroidsederhana.databinding.ActivityMainBinding
import com.naufal.aplikasiandroidsederhana.databinding.ActivityProfileMainBinding

class ProfileMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_main)
        binding = ActivityProfileMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}