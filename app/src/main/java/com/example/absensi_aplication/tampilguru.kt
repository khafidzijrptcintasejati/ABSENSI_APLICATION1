package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.absensi_aplication.databinding.ActivityTampilguruBinding
import com.example.absensi_aplication.databinding.ActivityTampilsiswaBinding
import com.example.absensi_aplication.room.DATABASE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class tampilguru : AppCompatActivity() {
        private val db by lazy { DATABASE.getInstance(this) }
        private lateinit var adapterGuru: Adapter_Guru
        private lateinit var binding: ActivityTampilguruBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityTampilguruBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val nama = intent.getStringExtra("nama").toString()
            val nip = intent.getStringExtra("nip").toString()

            binding.nama.text = "$nama"
            binding.nip.text = "$nip"

            binding.tambahguru.setOnClickListener {
                startActivity(Intent(this, activity_loginguru::class.java))
            }

            binding.btnbackguru.setOnClickListener {
                onBackPressed()
                startActivity(
                    Intent(this, MainActivity4::class.java)
                )
            }

            adapterGuru = Adapter_Guru(arrayListOf())

        }

        private fun tampilguru() {
            binding.rvguru.layoutManager = LinearLayoutManager(this)
            CoroutineScope(Dispatchers.IO).launch {
                val database = db.daoGuru().getAllguru()
                adapterGuru.setData(database)
                withContext(Dispatchers.Main) {
                    adapterGuru.notifyDataSetChanged()
                }
            }
            binding.rvguru.adapter = adapterGuru
        }

        override fun onResume() {
            super.onResume()
            tampilguru()
        }
    }