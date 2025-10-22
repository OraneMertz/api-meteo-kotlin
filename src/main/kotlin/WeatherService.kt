import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import models.Config

class WeatherService(private val config: Config) {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun fetchWeather(): WeatherData {
        val response: WeatherResponse = client.get(config.baseApiUrl) {
            url {
                parameters.append("q", config.city)
                parameters.append("appid", config.apiKey)
                parameters.append("units", "metric")
                parameters.append("lang", "fr")
            }
        }.body()

        return WeatherData(
            cityName = response.name,
            temperature = response.main.temp,
            humidity = response.main.humidity,
            windSpeed = response.wind.speed
        )
    }
}



