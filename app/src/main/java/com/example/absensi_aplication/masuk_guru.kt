package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.absensi_aplication.databinding.ActivityMasukGuruBinding
import com.example.absensi_aplication.room.DATABASE

class masuk_guru : AppCompatActivity() {
    private lateinit var binding :ActivityMasukGuruBinding
    private val db by lazy { DATABASE.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasukGuruBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = binding.namaguru
        val nip = binding.nipguru
            binding.masukguru.setOnClickListener{
            if (nama.text.isNotEmpty()&&nip.text.isNotEmpty()) {
                startActivity(
                    Intent(this, tampilguru::class.java).putExtra("nama", nama.text.toString())
                        .putExtra("nip", nip.text.toString())
                )
                alert("Login berhasil")

            }else{
                alert("Isi data terlebih dahulu")
            }
        }
    }

    private fun alert(msg:String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}