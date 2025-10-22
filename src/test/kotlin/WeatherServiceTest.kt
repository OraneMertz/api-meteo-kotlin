import kotlinx.coroutines.runBlocking
import models.Config
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WeatherServiceTest {

    private val config = Config(
        city = "Paris",
        apiKey = "YOUR_API_KEY",
        baseApiUrl = "https://api.openweathermap.org/data/2.5/weather",
        refresh = 3600000L
    )

    private val service = WeatherService(config)

    @Test
    fun `fetchWeather returns valid data`() = runBlocking {
        val weatherData = service.fetchWeather()

        assertEquals("Paris", weatherData.cityName)
        assertTrue(weatherData.temperature > -100)
        assertTrue(weatherData.humidity in 0..100)
        assertTrue(weatherData.windSpeed > 0)
    }
}