package com.example.absensi_aplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Siswa::class], version = 0)
abstract class DBSiswa : RoomDatabase(){
    abstract fun barangDao() : DaoSiswa

    companion object{

        @Volatile
        private var instance : DBSiswa? = null

        @Synchronized
        fun getInstance(context: Context) : DBSiswa {

            if (instance == null) {
                instance = Room.databaseBuilder(context, DBSiswa::class.java, "db_barang")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }

    }

}