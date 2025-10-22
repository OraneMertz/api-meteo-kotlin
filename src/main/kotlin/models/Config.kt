package models

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val city: String,
    val apiKey: String,
    val baseApiUrl: String,
    val refresh: Long
)