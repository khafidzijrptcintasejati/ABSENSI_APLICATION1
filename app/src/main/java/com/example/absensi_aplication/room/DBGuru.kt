package com.example.absensi_aplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
 @Database(entities = [Guru::class], version = 0)
abstract class DBGuru: RoomDatabase(){
    abstract fun barangDao() : DaoGuru

    companion object{

        @Volatile
        private var instance : DBGuru? = null

        @Synchronized
        fun getInstance(context: Context) : DBGuru {

            if (instance == null) {
                instance = Room.databaseBuilder(context, DBGuru::class.java, "db_barang")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }

    }


}