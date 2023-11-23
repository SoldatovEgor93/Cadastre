package ru.soldatov.android.cadastre.data.news.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsDbModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val annotation: String,
    val text: String?,
    val date: String,
    val updated: String,
    val image: String,
    val thumbnail: String
)