package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.absensi_aplication.databinding.ActivityTampilguruBinding
import com.example.absensi_aplication.databinding.ActivityUpdateGuruBinding
import com.example.absensi_aplication.room.DATABASE
import com.example.absensi_aplication.room.Guru

class UpdateGuru : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateGuruBinding
    private val db by lazy { DATABASE.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateGuruBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nip = intent.getStringExtra("nipGuru").toString().toInt()
        val data = db.daoGuru().getKODE(Kode = 0)

        binding.updatenipguru.setText(data[0].nip_guru)
        binding.updatenamaguru.setText(data[0].nama_guru)
        binding.updatetanggalguru.setText(data[0].tanggal_guru)
        binding.updateketeranganguru.setText(data[0].keterangan_guru)
        binding.updatemasukguru.setOnClickListener {
            if (binding.updatenipguru.text.isNotEmpty() &&
                binding.updatenamaguru.text.isNotEmpty() &&
                binding.updatetanggalguru.text.isNotEmpty() &&
                binding.updateketeranganguru.text.isNotEmpty()) {

                db.daoGuru().updateguru(Guru( nip.toString(),
                    binding.updatenamaguru.text.toString().toInt(),
                    binding.updatetanggalguru.text.toString().toInt(),
                    binding.updateketeranganguru.text.toString()))

                Toast.makeText(applicationContext,"data berhasil diubah",
                    Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,ActivityTampilguruBinding::class.java)
                )
                onBackPressed()
            }else{
                Toast.makeText(applicationContext,"udah data terlebih dahulu",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}