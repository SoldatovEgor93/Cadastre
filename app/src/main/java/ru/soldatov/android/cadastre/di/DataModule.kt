package ru.soldatov.android.cadastre.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.soldatov.android.cadastre.data.news.database.AppDatabase
import ru.soldatov.android.cadastre.data.news.database.NewsDao
import ru.soldatov.android.cadastre.data.news.network.ApiFactory
import ru.soldatov.android.cadastre.data.news.network.ApiService
import ru.soldatov.android.cadastre.data.news.repository.NewsRepositoryImpl
import ru.soldatov.android.cadastre.domain.news.repository.NewsRepository

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepositoryImpl(repositoryImpl: NewsRepositoryImpl): NewsRepository

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

    }

}