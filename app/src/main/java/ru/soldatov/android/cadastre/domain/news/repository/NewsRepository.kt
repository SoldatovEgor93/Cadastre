package ru.soldatov.android.cadastre.domain.news.repository

import androidx.lifecycle.LiveData
import ru.soldatov.android.cadastre.domain.news.model.News

interface NewsRepository {

    fun getNewsById(id: Int): News

    fun getNewsList(): LiveData<List<News>>

    fun loadNews()

}