package com.example.absensi_aplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_siswa")
data class Siswa(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "nis_siswa")    val Nis_siswa     : Int,
    @ColumnInfo(name = "nama_siswa")  val nama_siswa    : String,
    @ColumnInfo(name = "kelas_siswa") val kelas_siswa   : String,
    @ColumnInfo(name = "tanggal_siswa")  val tanggal_siswa    : Int,
    @ColumnInfo(name = "keterangan_siswa")  val keterangan_siswa    : String


)
