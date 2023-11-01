package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.absensi_aplication.databinding.ActivityTampilsiswaBinding
import com.example.absensi_aplication.room.DATABASE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class tampilsiswa : AppCompatActivity() {
    private val db by lazy { DATABASE.getInstance(this) }
    private lateinit var adapterSiswa: Adapter_Siswa
    private lateinit var binding: ActivityTampilsiswaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilsiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama=intent.getStringExtra("nama").toString()
        val nis=intent.getStringExtra("nis").toString()

        binding.tpNama.text= "$nama"
        binding.tpNis.text= "$nis"

        binding.tambahsiswa.setOnClickListener{
            startActivity(Intent(this, inputsswa_MainActivity::class.java))
        }

        binding.btnbacksiswa.setOnClickListener{
            onBackPressed()
            startActivity(
                Intent(this,MainActivity4::class.java)
            )
        }

        adapterSiswa = Adapter_Siswa(arrayListOf())

    }
    private fun tampilsiswa(){
        binding.rvsiswa.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            val database = db.daoSiswa().getAllSiswa()
            adapterSiswa.setData(database)
            withContext(Dispatchers.Main){
                adapterSiswa.notifyDataSetChanged()
            }
        }
        binding.rvsiswa.adapter = adapterSiswa
    }

    override fun onResume() {
        super.onResume()
        tampilsiswa()
    }
}