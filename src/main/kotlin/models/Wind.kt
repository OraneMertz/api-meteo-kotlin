package models

import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    val speed: Double
)