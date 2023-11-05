package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.absensi_aplication.databinding.ActivityLoginguruBinding
import com.example.absensi_aplication.room.DATABASE
import com.example.absensi_aplication.room.Guru

class activity_loginguru : AppCompatActivity() {
    private lateinit var binding : ActivityLoginguruBinding
    private val db by lazy { DATABASE.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginguruBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.masukguru.setOnClickListener{
            if (binding.namaguru.text.isNotEmpty() &&
                binding.nipguru2.text.isNotEmpty()&&
                binding.tanggalguru.text.isNotEmpty()&&
                binding.keteranganguru.text.isNotEmpty()){

                db.daoGuru().insertguru(
                    Guru(
                    binding.namaguru.text.toString(),
                    binding.nipguru2.text.toString().toInt(),
                    binding.tanggalguru.text.toString().toInt(),
                    binding.keteranganguru.text.toString()
                )
                )

                binding.namaguru.setText("")
                binding.nipguru2.setText("")
                binding.tanggalguru.setText("")
                binding.keteranganguru.setText("")

                Toast.makeText(applicationContext,"data berhasil di tambahkan", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,tampilguru::class.java))
                finish()
            } else{
                Toast.makeText(applicationContext,"isi data terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}