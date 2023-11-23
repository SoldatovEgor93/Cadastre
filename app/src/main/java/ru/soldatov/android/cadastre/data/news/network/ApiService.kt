package ru.soldatov.android.cadastre.data.news.network

import retrofit2.http.GET
import retrofit2.http.Headers
import ru.soldatov.android.cadastre.data.news.model.NewsListResponseDto
import ru.soldatov.android.cadastre.data.news.model.NewsResponseDto

interface ApiService {

    @Headers(AUTHORIZATION)
    @GET("news")
    suspend fun getNewsList(): NewsListResponseDto

    companion object {
        private const val TOKEN = "Hf8eNK93fje(3lvs#w"
        private const val AUTHORIZATION = "Authorization: $TOKEN"
    }

}