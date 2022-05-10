package com.example.examplemvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examplemvvm.data.database.dao.QuoteDao
import com.example.examplemvvm.data.database.entities.QuoteEntity
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDataBase : RoomDatabase() {


    abstract fun getQuoteDao(): QuoteDao


    //Yeralis
    /*companion object {

        private const val DB_NAME = "quote_database"
        internal const val DB_VERSION = 1

        // For Singleton instantiation
        @Volatile
        private var instance: QuoteDataBase? = null

        internal fun getInstance(context: Context): QuoteDataBase =
            instance ?: synchronized(this) {
                instance ?: buildDataBase(context).also { instance = it }
            }


        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(context, QuoteDataBase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }*/
}