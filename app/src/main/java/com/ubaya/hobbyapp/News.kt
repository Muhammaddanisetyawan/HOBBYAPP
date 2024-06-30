package com.ubaya.hobbyapp.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ubaya.hobbyapp.data.entities.converters.StringListConverter

@Entity(tableName = "news")
@TypeConverters(StringListConverter::class)
data class News(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val judul: String,
    val deskripsiSingkat: String,
    val category: List<String>,
    @Embedded val pengarang: Author
)

data class Author(
    val name: String,
    val bio: String
)
