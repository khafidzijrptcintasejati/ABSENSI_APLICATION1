package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.absensi_aplication.databinding.ActivityLoginsiswaBinding
import com.example.absensi_aplication.databinding.ActivityMain4Binding
import com.example.absensi_aplication.databinding.ActivityTampilsiswaBinding
import com.example.absensi_aplication.room.DATABASE
import com.example.absensi_aplication.room.Guru

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding : ActivityMain4Binding
    private val db by lazy { DATABASE.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = binding.namasiswa
        val nis = binding.nissiswa
        val kelas = binding.loginkelassiswa
        binding.masuksiswa.setOnClickListener{
            if (nama.text.isNotEmpty()&&nis.text.isNotEmpty()) {
                startActivity(
                    Intent(this, tampilsiswa::class.java).putExtra("nama", nama.text.toString())
                        .putExtra("nis", nis.text.toString()).putExtra("kelas", kelas.text.toString())
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
