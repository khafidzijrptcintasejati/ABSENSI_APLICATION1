package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.absensi_aplication.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain5Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnguru2.setOnClickListener{
            startActivity(Intent(this,MainActivity4::class.java))
        }
        binding.btnmrd2.setOnClickListener{
            startActivity(Intent(this,MainActivity4::class.java))
        }

    }
}