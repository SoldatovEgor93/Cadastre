package ru.soldatov.android.cadastre.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.soldatov.android.cadastre.data.AppDatabase
import ru.soldatov.android.cadastre.data.definitions.database.DefinitionsDao
import ru.soldatov.android.cadastre.data.definitions.repository.DefinitionsRepositoryImpl
import ru.soldatov.android.cadastre.data.network.ApiFactory
import ru.soldatov.android.cadastre.data.network.ApiService
import ru.soldatov.android.cadastre.data.news.database.NewsDao
import ru.soldatov.android.cadastre.data.news.repository.NewsRepositoryImpl
import ru.soldatov.android.cadastre.domain.definitions.repository.DefinitionsRepository
import ru.soldatov.android.cadastre.domain.news.repository.NewsRepository

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindNewsRepositoryImpl(repositoryImpl: NewsRepositoryImpl): NewsRepository

    @Binds
    @ApplicationScope
    fun bindDefinitionsRepositoryImpl(repositoryImpl: DefinitionsRepositoryImpl): DefinitionsRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        @ApplicationScope
        fun provideNewsDao(
            application: Application
        ): NewsDao {
            return AppDatabase.getInstance(application).newsDao()
        }

        @Provides
        @ApplicationScope
        fun provideDefinitionsDao(
            application: Application
        ): DefinitionsDao {
            return AppDatabase.getInstance(application).definitionsDao()
        }

    }

}