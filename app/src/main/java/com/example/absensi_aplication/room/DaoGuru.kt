package com.example.absensi_aplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface DaoGuru {
    @Query("SELECT * FROM tb_Guru")
    fun getAllguru() : List<Guru>

    @Insert
    fun insertguru( guru: Guru)

    @Update
    fun updateguru(guru: Guru)

    @Delete
    fun deleteguru(guru: Guru)

    @Query("SELECT * FROM tb_Guru WHERE nip_guru =:Kode")
    fun getKODE(Kode:Int): List<Guru>

}