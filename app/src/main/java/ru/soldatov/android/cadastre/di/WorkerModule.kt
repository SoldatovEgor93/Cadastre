package ru.soldatov.android.cadastre.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.soldatov.android.cadastre.data.definitions.workers.LoadDefinitionsDataWorker
import ru.soldatov.android.cadastre.data.workerfactory.ChildWorkerFactory
import ru.soldatov.android.cadastre.data.news.workers.LoadNewsDataWorker

@Module
interface WorkerModule {


    @Binds
    @IntoMap
    @WorkerKey(LoadNewsDataWorker::class)
    fun bindLoadDataWorker(worker: LoadNewsDataWorker.Factory): ChildWorkerFactory

    @Binds
    @IntoMap
    @WorkerKey(LoadDefinitionsDataWorker::class)
    fun bindLoadDefinitionsDataWorker(worker: LoadDefinitionsDataWorker.Factory): ChildWorkerFactory

}