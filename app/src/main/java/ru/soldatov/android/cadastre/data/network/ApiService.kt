package ru.soldatov.android.cadastre.data.network

import retrofit2.http.GET
import retrofit2.http.Headers
import ru.soldatov.android.cadastre.data.definitions.model.DefinitionsListResponseDto
import ru.soldatov.android.cadastre.data.news.model.NewsListResponseDto

interface ApiService {

    @Headers(AUTHORIZATION)
    @GET("news")
    suspend fun getNewsList(): NewsListResponseDto

    @Headers(AUTHORIZATION)
    @GET("definitions")
    suspend fun getDefinitionsList(): DefinitionsListResponseDto

    companion object {
        private const val TOKEN = "Hf8eNK93fje(3lvs#w"
        private const val AUTHORIZATION = "Authorization: $TOKEN"
    }

}