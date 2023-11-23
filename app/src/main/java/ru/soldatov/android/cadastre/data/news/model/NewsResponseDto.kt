package ru.soldatov.android.cadastre.data.news.model

data class NewsResponseDto(
    val id: Int,
    val title: String,
    val annotation: String,
    val text: String?,
    val date: String,
    val updated: String,
    val image: String,
    val thumbnail: String
)