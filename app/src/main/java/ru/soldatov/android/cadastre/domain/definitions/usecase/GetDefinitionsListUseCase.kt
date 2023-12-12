package ru.soldatov.android.cadastre.domain.definitions.usecase

import ru.soldatov.android.cadastre.domain.definitions.repository.DefinitionsRepository
import javax.inject.Inject

class GetDefinitionsListUseCase @Inject constructor(
    private val repository: DefinitionsRepository
) {

    operator fun invoke() = repository.getDefinitionsList()

}