package ru.soldatov.android.cadastre

import android.app.Application
import androidx.work.Configuration
import ru.soldatov.android.cadastre.data.workerfactory.WorkerFactory
import ru.soldatov.android.cadastre.di.DaggerApplicationComponent
import javax.inject.Inject

class CadastreApp: Application(), Configuration.Provider {

    @Inject
    lateinit var workerManager: WorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerManager)
            .build()
    }
}