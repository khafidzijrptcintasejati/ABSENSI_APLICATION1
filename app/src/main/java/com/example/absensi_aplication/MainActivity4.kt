package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.absensi_aplication.databinding.ActivityMain3Binding
import com.example.absensi_aplication.databinding.ActivityMain4Binding
import com.example.absensi_aplication.room.DBSiswa
import com.example.absensi_aplication.room.Siswa

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding : ActivityMain4Binding
    private val db by lazy { DBSiswa.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.masukguru.setOnClickListener{
            if (binding.namaguru.text.isNotEmpty() &&
                binding.nipguru.text.isNotEmpty()&&
                binding.tanggalguru.text.isNotEmpty()&&
                binding.keteranganguru.text.isNotEmpty()){

                db.barangDao().insertSiswa(
                    Siswa(
                    0,
                    binding.namaguru.text.toString(),
                    binding.nipguru.text.toString(),
                    binding.tanggalguru.text.toString().toInt(),
                    binding.keteranganguru.text.toString()
                )
                )

                binding.namaguru.setText("")
                binding.nipguru.setText("")
                binding.tanggalguru.setText("")
                binding.keteranganguru.setText("")

                Toast.makeText(applicationContext,"data berhasil di tambahkan", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            } else{
                Toast.makeText(applicationContext,"isi data terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}