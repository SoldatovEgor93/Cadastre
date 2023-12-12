package ru.soldatov.android.cadastre.data.news.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import ru.soldatov.android.cadastre.data.news.database.NewsDao
import ru.soldatov.android.cadastre.data.news.mapper.NewsMapper
import ru.soldatov.android.cadastre.data.news.workers.LoadNewsDataWorker
import ru.soldatov.android.cadastre.domain.news.model.News
import ru.soldatov.android.cadastre.domain.news.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val appContext: Application,
    private val newsDao: NewsDao,
    private val mapper: NewsMapper
) : NewsRepository {

    override fun getNewsById(id: Int): News {
        TODO("Not yet implemented")
    }

    override fun getNewsList(): LiveData<List<News>> {
        return Transformations.map(newsDao.getNewsList()) {
            mapper.mapDbToNewsList(it)
        }
    }

    override fun loadNews() {
        val workManager = WorkManager.getInstance(appContext)
        workManager.enqueueUniqueWork(
            LoadNewsDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            LoadNewsDataWorker.makeRequest()
        )
    }
}