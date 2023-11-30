package ru.soldatov.android.cadastre.data.definitions.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DefinitionsDao {

    @Query("SELECT * FROM definitions")
    fun getDefinitionsList(): LiveData<List<DefinitionDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDefinitionsList(definitionsList: List<DefinitionDbModel>)
}