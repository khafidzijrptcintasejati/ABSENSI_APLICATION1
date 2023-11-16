package com.example.absensi_aplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.absensi_aplication.databinding.ActivityTampilsiswaBinding
import com.example.absensi_aplication.room.DATABASE
import com.example.absensi_aplication.room.Siswa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class tampilsiswa : AppCompatActivity() {
    private val db by lazy { DATABASE.getInstance(this) }
    private lateinit var adapterSiswa: Adapter_Siswa
    private lateinit var binding: ActivityTampilsiswaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilsiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterSiswa = Adapter_Siswa(arrayListOf(),
            object : Adapter_Siswa.onAdapterListener {
                override fun hapus(siswa: Siswa) {
                    hapusData(siswa)
                }

                override fun Update(siswa: Siswa){
                    updateData(siswa)
                }
            })

        val nama = intent.getStringExtra("nama").toString()
        val nis = intent.getStringExtra("nis").toString()
        val kelas = intent.getStringExtra("kelas").toString()

        binding.tpNama.text = "$nama"
        binding.tpNis.text = "$nis"
        binding.kelas.text = "$kelas"

        binding.tambahsiswa.setOnClickListener {
            startActivity(Intent(this, input_siswa::class.java))
        }

        binding.btnbacksiswa.setOnClickListener {
            onBackPressed()
            startActivity(
                Intent(this, MainActivity4::class.java)
            )
        }

    }

    private fun hapusData(siswa: Siswa) {
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("KOnfirmasi hapus siswa")
            setMessage("Apakah anda yakin ingin menghapus data ini?")
            setNegativeButton("Batal") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }
            setPositiveButton("hapus") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.daoSiswa().hapus(siswa)
                }
                recreate()
                finish()
                startActivity(intent)
            }
        }
        dialog.show()
    }
     private fun updateData(siswa: Siswa){
         startActivity(Intent(this,Update::class.java).
         putExtra("nis_siswa", siswa.Nis_siswa.toString()))
     }

    private fun tampilsiswa(){
        binding.rvsiswa.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            val database = db.daoSiswa().getAllSiswa()
            adapterSiswa.setData(database)
            withContext(Dispatchers.Main){
                adapterSiswa.notifyDataSetChanged()
            }
        }
        binding.rvsiswa.adapter = adapterSiswa
    }

    override fun onResume() {
        super.onResume()
        tampilsiswa()
    }
}