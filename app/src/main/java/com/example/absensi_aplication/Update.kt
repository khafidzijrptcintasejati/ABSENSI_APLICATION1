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

    private lateinit var binding : ActivityUpdateBinding
    private val db by lazy { DATABASE.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("nis_siswa").toString().toInt()
        val data = db.daoSiswa().getSiswaById(id)[0]

        binding.updatenissiwa.setText(data.Nis_siswa.toString())
        binding.updatenamasiswa.setText(data.nama_siswa)
        binding.updatekelassiswa.setText(data.kelas_siswa)
        binding.updatetanggalsiswa.setText(data.tanggal_siswa.toString())
        binding.updateketerangansiswa.setText(data.kelas_siswa)
        binding.updatemasuksiswa.setOnClickListener {

            if( binding.updatenissiwa.text.isNotEmpty()&&
                binding.updatenamasiswa.text.isNotEmpty()&&
                binding.updatekelassiswa.text.isNotEmpty()&&
                binding.updatetanggalsiswa.text.isNotEmpty()&&
                binding.updateketerangansiswa.text.isNotEmpty()){

                db.daoSiswa().updateSiswa(Siswa(
                    id,
                    binding.updatenamasiswa.text.toString(),
                    binding.updatekelassiswa.text.toString(),
                    binding.updatetanggalsiswa.text.toString().toInt(),
                    binding.updateketerangansiswa.text.toString())
                )
                Toast.makeText(applicationContext,"Data Berhasil Diubah",
                Toast.LENGTH_SHORT).show()
                onBackPressed()
            }else{
                Toast.makeText(applicationContext,"ubah data terleih dahulu",
                Toast.LENGTH_SHORT).show()
            }
    }
    }
}