package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.absensi_aplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGuru.setOnClickListener {
            startActivity(Intent(this, masuk_guru::class.java))
        }
            binding.btnMrd.setOnClickListener {
                startActivity(Intent(this, MainActivity4::class.java))
            }

        }
    }