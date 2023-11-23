package ru.soldatov.android.cadastre.domain.news.usecase

import ru.soldatov.android.cadastre.domain.news.repository.NewsRepository
import javax.inject.Inject

class LoadNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    operator fun invoke() = repository.loadNews()
}