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

    @Insert
    fun insertSiswa( entitySiswa: Siswa)

    @Update
    fun updateSiswa(entitySiswa: Siswa)

    @Delete
    fun deleteBrg(entitySiswa: Siswa)

}