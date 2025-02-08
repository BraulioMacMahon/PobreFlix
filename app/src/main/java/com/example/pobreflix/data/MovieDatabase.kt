package com.example.pobreflix.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class, UserEntity::class], version = 3) // Aumente a versão
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun userDao(): UserDao // Adicionado

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pobreflix_database"
                )
                    .fallbackToDestructiveMigration() // Permite recriar o banco caso precise
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
