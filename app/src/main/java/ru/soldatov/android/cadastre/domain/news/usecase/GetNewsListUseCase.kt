package ru.soldatov.android.cadastre.domain.news.usecase

import androidx.lifecycle.LiveData
import ru.soldatov.android.cadastre.domain.news.model.News
import ru.soldatov.android.cadastre.domain.news.repository.NewsRepository
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    operator fun invoke(): LiveData<List<News>> = repository.getNewsList()
}