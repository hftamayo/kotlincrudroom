package com.hftamayo.kotlincrudroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.hftamayo.kotlincrudroom.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume(){
        super.onResume()
        lifecycleScope.launch {
            val userList = AppDatabase(this@MainActivity).getUserDao().getAllUser()
            Log.e("from MainActivity", "onResume event length of users list: ${userList.size}")

        }
    }
}
