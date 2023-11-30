package ru.soldatov.android.cadastre.presentation

import androidx.lifecycle.ViewModel
import ru.soldatov.android.cadastre.domain.definitions.usecase.GetDefinitionByIdUseCase
import ru.soldatov.android.cadastre.domain.definitions.usecase.GetDefinitionsListUseCase
import ru.soldatov.android.cadastre.domain.definitions.usecase.LoadDefinitionsUseCase
import ru.soldatov.android.cadastre.domain.news.usecase.GetNewsListUseCase
import ru.soldatov.android.cadastre.domain.news.usecase.LoadNewsUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getNewsListUseCase: GetNewsListUseCase,
    getDefinitionsListUseCase: GetDefinitionsListUseCase,
    private val loadNewsUseCase: LoadNewsUseCase,
    private val loadDefinitionsUseCase: LoadDefinitionsUseCase
) : ViewModel() {

    init {
//        loadNewsUseCase()
        loadDefinitionsUseCase()
    }

    fun refresh() {
//        loadNewsUseCase()
        loadDefinitionsUseCase()
    }

    val newsList = getNewsListUseCase()
    val definitionsList = getDefinitionsListUseCase()

}