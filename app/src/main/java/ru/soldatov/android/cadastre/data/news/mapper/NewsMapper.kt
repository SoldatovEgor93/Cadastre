package ru.soldatov.android.cadastre.data.news.mapper

import ru.soldatov.android.cadastre.data.news.database.NewsDbModel
import ru.soldatov.android.cadastre.data.news.model.NewsResponseDto
import ru.soldatov.android.cadastre.domain.news.model.News
import javax.inject.Inject

class NewsMapper @Inject constructor() {

    fun mapResponseToDbModel(newsResponse: NewsResponseDto) =  NewsDbModel(
        id = newsResponse.id,
        title = newsResponse.title,
        annotation = newsResponse.annotation,
        text = newsResponse.text,
        date = newsResponse.date,
        updated = newsResponse.updated,
        image = newsResponse.image,
        thumbnail = newsResponse.thumbnail
    )

    private fun mapDbToNews(newsDbModel: NewsDbModel): News {
        return News(
            id = newsDbModel.id,
            title = newsDbModel.title,
            annotation = newsDbModel.annotation,
            text = newsDbModel.text ?: UNKNOWN_TEXT,
            date = newsDbModel.date,
            updated = newsDbModel.updated,
            image = newsDbModel.image,
            thumbnail = newsDbModel.thumbnail
        )
    }

    fun mapDbToNewsList(list: List<NewsDbModel>): List<News> {
        return list.map { mapDbToNews(it) }.sortedByDescending { it.date }
    }

    companion object {

        private const val UNKNOWN_TEXT = ""

    }

}