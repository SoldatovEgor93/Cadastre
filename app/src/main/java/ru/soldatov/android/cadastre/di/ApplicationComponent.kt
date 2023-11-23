package ru.soldatov.android.cadastre.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.soldatov.android.cadastre.CadastreApp
import ru.soldatov.android.cadastre.presentation.MainActivity

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(application: CadastreApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent

    }

}