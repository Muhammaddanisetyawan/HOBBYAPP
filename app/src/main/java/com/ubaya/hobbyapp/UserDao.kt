package com.ubaya.hobbyapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ubaya.hobbyapp.data.entities.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    suspend fun login(username: String, password: String): User?
}
