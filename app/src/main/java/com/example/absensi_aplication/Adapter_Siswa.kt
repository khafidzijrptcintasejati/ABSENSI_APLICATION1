package com.example.absensi_aplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.absensi_aplication.room.Siswa

class Adapter_Siswa(private val list: ArrayList<Siswa>) : RecyclerView.Adapter<Adapter_Siswa.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nama : TextView = itemView.findViewById(R.id.adapternama)
        val keterangan : TextView = itemView.findViewById(R.id.adapterketerangan)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adaptersiswa,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nama.text = list[position].nama_siswa.toString()
        holder.keterangan.text = list[position].keterangan_siswa.toString()

    }

    fun setData(newLlist : List<Siswa>) {
        list.clear()
        list.addAll(newLlist)
    }
}