package com.example.absensi_aplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
 @Database(entities = [Guru::class, Siswa::class], version = 3)
abstract class DATABASE: RoomDatabase(){
    abstract fun daoGuru() : DaoGuru
    abstract fun daoSiswa() : DaoSiswa

    companion object{

        @Volatile
        private var instance : DATABASE? = null

        @Synchronized
        fun getInstance(context: Context) : DATABASE {

            if (instance == null) {
                instance = Room.databaseBuilder(context, DATABASE::class.java, "db_barang")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }

    }


}