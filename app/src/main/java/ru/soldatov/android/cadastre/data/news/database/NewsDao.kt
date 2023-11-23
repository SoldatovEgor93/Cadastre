package ru.soldatov.android.cadastre.data.news.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getNewsList(): LiveData<List<NewsDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsList(newsList: List<NewsDbModel>)

}