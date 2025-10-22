import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import models.Config
import java.io.File

@Serializable
data class Main(val temp: Double, val humidity: Int)

suspend fun main() {
    val configFile = File("config.json")
    val configJson = configFile.readText()
    val config = Json.decodeFromString<Config>(configJson)

    val weatherService = WeatherService(config)

    val weatherData = weatherService.fetchWeather()
    println("🌤️ Météo pour ${weatherData.cityName}")
    println("🌡️ Température: ${weatherData.temperature}°C")
    println("💧 Humidité: ${weatherData.humidity}%")
    println("🌬️ Vent: ${weatherData.windSpeed} km/h")

}
