package ru.soldatov.android.cadastre.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.soldatov.android.cadastre.data.definitions.database.DefinitionDbModel
import ru.soldatov.android.cadastre.data.definitions.database.DefinitionsDao
import ru.soldatov.android.cadastre.data.news.database.NewsDao
import ru.soldatov.android.cadastre.data.news.database.NewsDbModel

@Database(
    entities = [
        NewsDbModel::class,
        DefinitionDbModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    abstract fun definitionsDao(): DefinitionsDao

    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "cadastre"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }

    }

}