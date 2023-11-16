package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.absensi_aplication.databinding.ActivityTampilsiswaBinding
import com.example.absensi_aplication.databinding.ActivityUpdateBinding
import com.example.absensi_aplication.room.DATABASE
import com.example.absensi_aplication.room.Siswa

class Update : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private val db by lazy {DATABASE.getInstance(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val KODE= intent.getStringExtra("nis_siswa").toString().toInt()
        val data = db.daoSiswa().getKODE(KODE)

        binding.editnis.setText(data[0].Nis_siswa.toString().toInt())
        binding.editnama.setText(data[0].nama_siswa)
        binding.editkelas.setText(data[0].kelas_siswa)
        binding.edittanggal.setText(data[0].tanggal_siswa.toString().toInt())
        binding.editketerangan.setText(data[0].keterangan_siswa)
        binding.editmasuk.setOnClickListener {
            if (binding.editnis.text.isNotEmpty() &&
                binding.editnama.text.isNotEmpty() &&
                binding.editkelas.text.isNotEmpty() &&
                binding.edittanggal.text.isNotEmpty() &&
                binding.editketerangan.text.isNotEmpty()){

                db.daoSiswa().updateSiswa(
                    Siswa(
                        KODE,
                        binding.editnama.text.toString(),
                        binding.editkelas.text.toString(),
                        binding.edittanggal.text.toString().toInt(),
                        binding.editketerangan.text.toString(),
                        ))
                Toast.makeText(applicationContext,"data berhasil diubah", Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(this,ActivityTampilsiswaBinding::class.java)
                )
                onBackPressed()
            }else{
                Toast.makeText(applicationContext,"ubah data terlebih dahulu", Toast.LENGTH_SHORT).show()

            }
        }
    }
}

