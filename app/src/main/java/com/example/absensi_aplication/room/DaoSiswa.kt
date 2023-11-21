package com.example.absensi_aplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoSiswa{

    @Query("SELECT * FROM tb_siswa")
    fun getAllSiswa() : List<Siswa>

    @Query("SELECT*FROM tb_siswa WHERE nis_siswa = :nis")
    fun getSiswaById(nis : Int) : List<Siswa>

    @Insert
    fun insertSiswa( siswa: Siswa)

    @Update
    fun updateSiswa(siswa: Siswa)

    @Delete
    fun hapus(siswa: Siswa)

    @Query("SELECT * FROM tb_siswa WHERE nis_siswa =:KODE")
    fun getKODE(KODE:Int): List<Siswa>


}