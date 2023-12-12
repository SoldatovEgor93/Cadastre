package ru.soldatov.android.cadastre.domain.news.model

data class News(
    val id: Int,
    val title: String,
    val annotation: String,
    val text: String,
    val date: String,
    val updated: String,
    val image: String,
    val thumbnail: String
)
