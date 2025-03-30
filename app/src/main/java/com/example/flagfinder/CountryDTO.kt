package com.example.flagfinder

import kotlinx.serialization.Serializable

@Serializable
data class CountryDTO(
    val code: String,
    val name: String,
    val flagUrl: String
)
