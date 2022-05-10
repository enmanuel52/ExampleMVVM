package com.example.examplemvvm.di

import android.content.Context
import androidx.room.Room
import com.example.examplemvvm.data.database.QuoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private val quoteDatabaseName = "quote_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDataBase::class.java, quoteDatabaseName).build()

    @Provides
    fun provideQuoteDao(db: QuoteDataBase) = db.getQuoteDao()

}