package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.absensi_aplication.databinding.InputsiswaActivityBinding
import com.example.absensi_aplication.room.DATABASE
import com.example.absensi_aplication.room.Siswa


class inputsswa_MainActivity : AppCompatActivity() {
    private lateinit var binding : InputsiswaActivityBinding
    private val db by lazy { DATABASE.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InputsiswaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.masuk.setOnClickListener{
            if (binding.nis.text.isNotEmpty() &&
                binding.namasiswa.text.isNotEmpty()&&
                binding.kelas.text.isNotEmpty()&&
                binding.tanggal.text.isNotEmpty()&&
                binding.keterangan.text.isNotEmpty()){

                db.daoSiswa().insertSiswa(Siswa(
                    0,
                    binding.namasiswa.text.toString(),
                    binding.kelas.text.toString(),
                    binding.tanggal.text.toString().toInt(),
               binding.keterangan.text.toString()
                ))

                binding.nis.setText("")
                binding.namasiswa.setText("")
                binding.kelas.setText("")
                binding.tanggal.setText("")
                binding.keterangan.setText("")

                Toast.makeText(applicationContext,"data berhasil di tambahkan",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,tampilsiswa::class.java))
                finish()
            } else{
            Toast.makeText(applicationContext,"isi data terlebih dahulu", Toast.LENGTH_SHORT).show()
        }
        }
    }
}