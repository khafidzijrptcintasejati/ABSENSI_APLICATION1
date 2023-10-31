package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.absensi_aplication.databinding.ActivityMain3Binding
import com.example.absensi_aplication.room.DATABASE
import com.example.absensi_aplication.room.Siswa

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding : ActivityMain3Binding
    private val db by lazy { DATABASE.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.masuksiswa.setOnClickListener{
            if (binding.nissiwa.text.isNotEmpty() &&
                binding.namasiswa.text.isNotEmpty()&&
                binding.kelassiswa.text.isNotEmpty()&&
                binding.tanggalsiswa.text.isNotEmpty()&&
                binding.keterangansiswa.text.isNotEmpty()){

                db.daoSiswa().insertSiswa(Siswa(
                    0,
                    binding.namasiswa.text.toString(),
                    binding.kelassiswa.text.toString(),
                    binding.tanggalsiswa.text.toString().toInt(),
                    binding.keterangansiswa.text.toString()
                ))

                binding.nissiwa.setText("")
                binding.namasiswa.setText("")
                binding.kelassiswa.setText("")
                binding.tanggalsiswa.setText("")
                binding.keterangansiswa.setText("")

                Toast.makeText(applicationContext,"data berhasil di tambahkan",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            } else{
                Toast.makeText(applicationContext,"isi data terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}