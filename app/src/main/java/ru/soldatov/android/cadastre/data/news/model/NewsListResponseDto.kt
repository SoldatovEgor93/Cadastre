package ru.soldatov.android.cadastre.data.news.model

import com.google.gson.annotations.SerializedName

data class NewsListResponseDto(
    @SerializedName("data")
    val list: List<NewsResponseDto>?
)