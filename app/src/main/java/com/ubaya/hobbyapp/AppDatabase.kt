package com.ubaya.hobbyapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.ubaya.hobbyapp.data.dao.NewsDao
import com.ubaya.hobbyapp.data.dao.UserDao
import com.ubaya.hobbyapp.data.entities.News
import com.ubaya.hobbyapp.data.entities.User

@Database(entities = [User::class, News::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "hobby_app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
