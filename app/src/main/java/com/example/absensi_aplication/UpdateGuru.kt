package com.example.absensi_aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        val data = db.daoGuru().getKODE(nip) [0]


        binding.updatenamaguru.setText(data.nama_guru).toString()
        binding.updatenipguru.setText(data.nip_guru).toString().toInt()
        binding.updatetanggalguru.setText(data.tanggal_guru).toString().toInt()
        binding.updateketeranganguru.setText(data.keterangan_guru).toString()
        binding.updatemasukguru.setOnClickListener {

            if (binding.updatenamaguru.text.isNotEmpty() &&
                binding.updatenipguru.text.isNotEmpty() &&
                binding.updatetanggalguru.text.isNotEmpty() &&
                binding.updateketeranganguru.text.isNotEmpty()) {

                db.daoGuru().updateguru(Guru(
                    binding.updatenamaguru.text.toString(),
                    nip,
                    binding.updatetanggalguru.text.toString().toInt(),
                    binding.updateketeranganguru.text.toString())
                )
                Toast.makeText(applicationContext,"data berhasil diubah",
                Toast.LENGTH_SHORT).show()
                onBackPressed()
            }else{
                Toast.makeText(applicationContext,"udah data terlebih dahulu",
                Toast.LENGTH_SHORT).show()
            }
    }

}
}