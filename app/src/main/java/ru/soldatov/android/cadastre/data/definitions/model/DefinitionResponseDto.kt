package ru.soldatov.android.cadastre.data.definitions.model

data class DefinitionResponseDto(
    val id: Int,
    val title: String,
    val annotation: String,
    val text: String,
    val updated: String
)