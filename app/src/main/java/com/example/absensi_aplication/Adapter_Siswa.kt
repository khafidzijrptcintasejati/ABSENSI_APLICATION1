package com.example.absensi_aplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.absensi_aplication.room.Siswa

class Adapter_Siswa(val list: ArrayList<Siswa>, val listener: onAdapterListener) : RecyclerView.Adapter<Adapter_Siswa.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nama : TextView = itemView.findViewById(R.id.tampilnamasswa)
        val kelas : TextView = itemView.findViewById(R.id.tampilkelassswa)
        val tanggal : TextView = itemView.findViewById(R.id.tampiltanggalsswa)
        val keterangan : TextView = itemView.findViewById(R.id.tampilketsswa)
        val delete : ImageView = itemView.findViewById(R.id.deletesiswa)
        val edit : ImageView = itemView.findViewById(R.id.mengeditsiswa)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adaptersiswa,
                parent,
                false)) }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nama.text = list[position].nama_siswa
        holder.kelas.text = list[position].kelas_siswa
        holder.tanggal.text = list[position].tanggal_siswa.toString()
        holder.keterangan.text = list[position].keterangan_siswa
        holder.delete.setOnClickListener {
            listener.hapus(list[position])

        }
        holder.edit.setOnClickListener {
            listener.Update(list[position])
        }
    }
    interface onAdapterListener{
        fun hapus(siswa: Siswa)
        fun Update(siswa: Siswa)}
    fun setData(newLlist : List<Siswa>) {
        list.clear()
        list.addAll(newLlist)
    }
}