package com.haguado.gueder

import com.haguado.gueder.model.Forecast
import com.haguado.gueder.model.TemperatureUnit
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ForecastUnitTest {

    lateinit var forecast: Forecast   // para evitar ponerlo con ??, pero como usamos @Before, que se ejecuta antes que nada, sabemos seguro q va a tener valor

    @Before
    fun setUp(){
         forecast = Forecast(25f, 10f, 35f, "soleado con alguna nube", R.drawable.ico_01)
    }

    @Test
    fun maxTempUnitsConversion_isCorrect(){
        assertEquals(77f, forecast.getMaxTemp(TemperatureUnit.FAHRENHEIT))
    }

    @Test
    fun minTempUnitsConvesion_isCorrect(){
        assertEquals(50f, forecast.getMinTemp(TemperatureUnit.FAHRENHEIT))
    }

    @Test (expected = IllegalArgumentException::class)
    fun humidityOverRange_ThrowsArgumentException(){
        Forecast(25f, 10f, 100.01f, "sol", R.drawable.ico_01)
    }

    @Test (expected = IllegalArgumentException::class)
    fun humidityLowerRange_ThrowsArgumentException(){
        Forecast(25f, 10f, -1.01f, "sol", R.drawable.ico_01)
    }
}