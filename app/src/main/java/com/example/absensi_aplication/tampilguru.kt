package com.example.absensi_aplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Delete
import com.example.absensi_aplication.databinding.ActivityTampilguruBinding
import com.example.absensi_aplication.room.DATABASE
import com.example.absensi_aplication.room.Guru
import com.example.absensi_aplication.room.Siswa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class tampilguru : AppCompatActivity() {
        private val db by lazy { DATABASE.getInstance(this) }
        private lateinit var adapterGuru: Adapter_Guru
        private lateinit var binding: ActivityTampilguruBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityTampilguruBinding.inflate(layoutInflater)
            setContentView(binding.root)

            adapterGuru = Adapter_Guru(arrayListOf(),
                object : Adapter_Guru.onAdapterListener {
                    override fun onDelete(guru: Guru) {
                        DeleteGuru(guru)
                    }

                    override fun onUpdate(guru: Guru) {
                        UpdateGuruu(guru)
                    }
                })

            val nama = intent.getStringExtra("nama").toString()
            val nip = intent.getStringExtra("nip").toString()

            binding.nama.text = "$nama"
            binding.nip.text = "$nip"

            binding.tambahguru.setOnClickListener {
                startActivity(Intent(this, activity_loginguru::class.java))
            }

            binding.btnbackguru.setOnClickListener {
                onBackPressed()
                startActivity(
                    Intent(this, MainActivity5::class.java)
                )
            }

                }
    private fun DeleteGuru(guru: Guru) {
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi hapus guru")
            setMessage("Apakah anda yakin ingin menghapus data ini?")
            setNegativeButton("Batal") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }
            setPositiveButton("hapus") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.daoGuru().deleteguru(guru)
                }
                recreate()
                finish()
                startActivity(intent)
            }
        }
        dialog.show()
    }
    private fun UpdateGuruu(guru: Guru){
        startActivity(Intent(this,UpdateGuru::class.java).
        putExtra("nipGuru",guru.nip_guru.toString()))
    }
    private fun tampilguru() {
        binding.rvguru.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            val database = db.daoGuru().getAllguru()
            adapterGuru.setData(database)
            withContext(Dispatchers.Main) {
                adapterGuru.notifyDataSetChanged()
            }
        }
        binding.rvguru.adapter = adapterGuru
    }

    override fun onResume() {
        super.onResume()
        tampilguru()
    }
}


