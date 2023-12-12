package ru.soldatov.android.cadastre.data.definitions.model

import com.google.gson.annotations.SerializedName

data class DefinitionsListResponseDto(
    @SerializedName("data")
    val list: List<DefinitionResponseDto>
)