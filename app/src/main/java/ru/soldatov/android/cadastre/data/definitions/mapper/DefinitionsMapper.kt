package ru.soldatov.android.cadastre.data.definitions.mapper

import ru.soldatov.android.cadastre.data.definitions.database.DefinitionDbModel
import ru.soldatov.android.cadastre.data.definitions.model.DefinitionResponseDto
import ru.soldatov.android.cadastre.domain.definitions.model.Definition
import javax.inject.Inject

class DefinitionsMapper @Inject constructor() {

    fun mapResponseToDbModel(definitionResponse: DefinitionResponseDto) = DefinitionDbModel(
        id = definitionResponse.id,
        title = definitionResponse.title,
        annotation = definitionResponse.annotation,
        text = definitionResponse.text,
        updated = definitionResponse.updated,
    )

    private fun mapDbToDefinition(definitionDbModel: DefinitionDbModel): Definition {
        return Definition(
            id = definitionDbModel.id,
            title = definitionDbModel.title,
            annotation = definitionDbModel.annotation,
            text = definitionDbModel.text ?: UNKNOWN_TEXT,
            updated = definitionDbModel.updated
        )
    }

    fun mapDbToDefinitionsList(list: List<DefinitionDbModel>): List<Definition> {
        return list.map { mapDbToDefinition(it) }.sortedByDescending { it.title }
    }

    companion object {

        private const val UNKNOWN_TEXT = ""

    }

}