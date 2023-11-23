package ru.soldatov.android.cadastre.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.soldatov.android.cadastre.data.workerfactory.ChildWorkerFactory
import ru.soldatov.android.cadastre.data.news.workers.LoadDataWorker

@Module
interface WorkerModule {


    @Binds
    @IntoMap
    @WorkerKey(LoadDataWorker::class)
    fun bindLoadDataWorker(worker: LoadDataWorker.Factory): ChildWorkerFactory

}