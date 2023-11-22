package com.example.absensi_aplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.absensi_aplication.databinding.ActivityDetailSiswaBinding
import com.example.absensi_aplication.databinding.ActivityMasukGuruBinding
import com.example.absensi_aplication.databinding.ActivityUpdateBinding
import com.example.absensi_aplication.room.DATABASE

class DetailSiswa : AppCompatActivity() {

    private lateinit var binding : ActivityDetailSiswaBinding
    private val db by lazy { DATABASE.getInstance(this)}

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityDetailSiswaBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val id = intent.getStringExtra("detailS").toString().toInt()
            val data = db.daoSiswa().getSiswaById(id)[0]


            binding.detailSnis.setText(data.Nis_siswa.toString())
            binding.detailSnama.setText(data.nama_siswa)
            binding.detailSkelas.setText(data.kelas_siswa)
            binding.detailStanggal.setText(data.tanggal_siswa.toString())
            binding.detailSketerangan.setText(data.keterangan_siswa)

        }
    }