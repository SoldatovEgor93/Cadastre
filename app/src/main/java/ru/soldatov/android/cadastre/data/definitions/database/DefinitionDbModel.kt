package ru.soldatov.android.cadastre.data.definitions.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "definitions")
data class DefinitionDbModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val annotation: String,
    val text: String?,
    val updated: String
)