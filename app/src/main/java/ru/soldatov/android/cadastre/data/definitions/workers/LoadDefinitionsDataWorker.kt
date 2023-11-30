package ru.soldatov.android.cadastre.data.definitions.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import ru.soldatov.android.cadastre.data.definitions.database.DefinitionsDao
import ru.soldatov.android.cadastre.data.definitions.mapper.DefinitionsMapper
import ru.soldatov.android.cadastre.data.network.ApiService
import ru.soldatov.android.cadastre.data.workerfactory.ChildWorkerFactory
import javax.inject.Inject

class LoadDefinitionsDataWorker(
    context: Context,
    params: WorkerParameters,
    private val apiService: ApiService,
    private val newsDao: DefinitionsDao,
    private val mapper: DefinitionsMapper
): CoroutineWorker(context, params) {


    override suspend fun doWork(): Result {
        val listResponse = apiService.getDefinitionsList()
        Log.d("LoadDefinitionsDataWorker", "${listResponse.list.size}")
        val dbMapList = listResponse.list.map {
            mapper.mapResponseToDbModel(it)
        }
        newsDao.insertDefinitionsList(dbMapList)
        return Result.success()
    }

    companion object {

        const val NAME = "LoadDefinitionsWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<LoadDefinitionsDataWorker>().build()
        }
    }

    class Factory @Inject constructor(
        private val apiService: ApiService,
        private val newsDao: DefinitionsDao,
        private val mapper: DefinitionsMapper
    ) : ChildWorkerFactory {

        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return LoadDefinitionsDataWorker(
                context,
                workerParameters,
                apiService,
                newsDao,
                mapper
            )
        }
    }
}