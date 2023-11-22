package com.example.absensi_aplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_Guru")
data class Guru(

    @PrimaryKey
    @ColumnInfo(name = "nip_guru" ) val nip_guru : Int,
    @ColumnInfo(name = "nama_guru")  val nama_guru    : String,
    @ColumnInfo(name = "tanggal_guru")  val tanggal_guru  : Int,
    @ColumnInfo(name = "keterangan_guru")  val keterangan_guru    : String
)

