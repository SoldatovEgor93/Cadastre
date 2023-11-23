package ru.soldatov.android.cadastre.data.workerfactory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import ru.soldatov.android.cadastre.data.news.workers.LoadDataWorker
import javax.inject.Inject
import javax.inject.Provider

class WorkerFactory @Inject constructor(
    private val workersProviders:
    @JvmSuppressWildcards Map<Class<out ListenableWorker>, Provider<ChildWorkerFactory>>
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            LoadDataWorker::class.qualifiedName -> {
                val childWorkerFactory = workersProviders[LoadDataWorker::class.java]?.get()
                return childWorkerFactory?.create(appContext, workerParameters)
            }
            else -> null
        }
    }
}