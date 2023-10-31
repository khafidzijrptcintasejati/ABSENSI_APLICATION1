package com.example.absensi_aplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.absensi_aplication.room.Guru
import com.example.absensi_aplication.room.Siswa

class Adapter_Guru (private val list: ArrayList<Guru>) : RecyclerView.Adapter<Adapter_Guru.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nama : TextView = itemView.findViewById(R.id.adapternamaguru)
        val tanggal : TextView = itemView.findViewById(R.id.adaptertanggalguru)
        val keterangan : TextView = itemView.findViewById(R.id.adapterketeranganguru)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
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

        holder.nama.text = list[position].nama_guru.toString()
        holder.tanggal.text = list[position].tanggal_guru.toString()
        holder.keterangan.text = list[position].keterangan_guru.toString()

    }

    fun setData(newLlist : List<Guru>) {
        list.clear()
        list.addAll(newLlist)
    }
}
