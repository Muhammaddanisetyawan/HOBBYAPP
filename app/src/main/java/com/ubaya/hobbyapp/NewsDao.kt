package com.ubaya.hobbyapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ubaya.hobbyapp.data.entities.News

@Dao
interface NewsDao {
    @Insert
    suspend fun insert(news: News)

    @Query("SELECT * FROM news")
    suspend fun getAllNews(): List<News>

    @Query("SELECT * FROM news WHERE id = :id")
    suspend fun getNewsById(id: Int): News
}
