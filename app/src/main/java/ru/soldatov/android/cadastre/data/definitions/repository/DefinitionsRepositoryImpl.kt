package ru.soldatov.android.cadastre.data.definitions.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import ru.soldatov.android.cadastre.data.definitions.database.DefinitionsDao
import ru.soldatov.android.cadastre.data.definitions.mapper.DefinitionsMapper
import ru.soldatov.android.cadastre.data.definitions.workers.LoadDefinitionsDataWorker
import ru.soldatov.android.cadastre.domain.definitions.model.Definition
import ru.soldatov.android.cadastre.domain.definitions.repository.DefinitionsRepository
import javax.inject.Inject

class DefinitionsRepositoryImpl @Inject constructor(
    private val appContext: Application,
    private val definitionsDao: DefinitionsDao,
    private val mapper: DefinitionsMapper
) : DefinitionsRepository {

    override fun getDefinitionById(id: Int): Definition {
        TODO("Not yet implemented")
    }

    override fun getDefinitionsList(): LiveData<List<Definition>> {
        return Transformations.map(definitionsDao.getDefinitionsList()){
            mapper.mapDbToDefinitionsList(it)
        }
    }

    override fun loadDefinitions() {
        val worker = WorkManager.getInstance(appContext)
        worker.enqueueUniqueWork(
            LoadDefinitionsDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            LoadDefinitionsDataWorker.makeRequest()
        )
    }
}