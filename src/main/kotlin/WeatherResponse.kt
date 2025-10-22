import kotlinx.serialization.Serializable
import models.Wind

@Serializable
data class WeatherResponse(
    val name: String,
    val main: Main,
    val wind: Wind
)