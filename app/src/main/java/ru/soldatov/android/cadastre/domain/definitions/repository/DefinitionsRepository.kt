package ru.soldatov.android.cadastre.domain.definitions.repository

import androidx.lifecycle.LiveData
import ru.soldatov.android.cadastre.domain.definitions.model.Definition

interface DefinitionsRepository {

    fun getDefinitionById(id: Int): Definition

    fun getDefinitionsList(): LiveData<List<Definition>>

    fun loadDefinitions()

}