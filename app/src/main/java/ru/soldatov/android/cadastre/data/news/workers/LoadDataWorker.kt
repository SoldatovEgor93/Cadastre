package ru.soldatov.android.cadastre.data.news.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import ru.soldatov.android.cadastre.data.workerfactory.ChildWorkerFactory
import ru.soldatov.android.cadastre.data.news.database.NewsDao
import ru.soldatov.android.cadastre.data.news.mapper.NewsMapper
import ru.soldatov.android.cadastre.data.news.network.ApiService
import javax.inject.Inject

class LoadDataWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val apiService: ApiService,
    private val newsDao: NewsDao,
    private val mapper: NewsMapper
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        val listResponse = apiService.getNewsList()
        return if (listResponse.list != null) {
            Log.d("LoadWorker", listResponse.list.size.toString())
            val dbMapList = listResponse.list.map {
                mapper.mapResponseToDbModel(it)
            }
            newsDao.insertNewsList(dbMapList)
            Result.success()
        } else {
            Log.d("LoadWorker", "Not load dara")
            Result.failure()
        }
    }

    companion object {

        const val NAME = "LoadNewsWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<LoadDataWorker>().build()
        }
    }

    class Factory @Inject constructor(
        private val apiService: ApiService,
        private val newsDao: NewsDao,
        private val mapper: NewsMapper
    ) : ChildWorkerFactory {

        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return LoadDataWorker(
                context,
                workerParameters,
                apiService,
                newsDao,
                mapper
            )
        }
    }
}