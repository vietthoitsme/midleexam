package com.example.midleexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midleexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    binding.listPhones.run {
        layoutManager = LinearLayoutManager(this@MainActivity)
        setHasFixedSize(true)
        adapter = PhoneAdapter(Phones)
    }
    binding.fabAdd.setOnClickListener {
        val intent = Intent(this@MainActivity, AddPhoneActivity::class.java)
        startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        // binding.listMusics.adapter = MusicAdapter(Musics)
        binding.listPhones.adapter?.notifyDataSetChanged()
    }
    companion object{
        val Phones = mutableListOf<Phone>()
    }
}