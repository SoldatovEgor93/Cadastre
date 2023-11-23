package ru.soldatov.android.cadastre.presentation

import androidx.lifecycle.ViewModel
import ru.soldatov.android.cadastre.domain.news.usecase.GetNewsListUseCase
import ru.soldatov.android.cadastre.domain.news.usecase.LoadNewsUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getNewsListUseCase: GetNewsListUseCase,
    private val loadNewsUseCase: LoadNewsUseCase
) : ViewModel() {

    init {
        loadNewsUseCase()
    }

    fun refresh() {
        loadNewsUseCase()
    }

    val newsList = getNewsListUseCase()

}