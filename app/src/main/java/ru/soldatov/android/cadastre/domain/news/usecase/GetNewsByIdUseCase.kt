package ru.soldatov.android.cadastre.domain.news.usecase

import ru.soldatov.android.cadastre.domain.news.model.News
import ru.soldatov.android.cadastre.domain.news.repository.NewsRepository
import javax.inject.Inject

class GetNewsByIdUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    operator fun invoke(id: Int): News = repository.getNewsById(id)
}