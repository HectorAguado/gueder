package com.haguado.gueder.model

import java.io.Serializable

data class City(var name: String, var forecast: Forecast): Serializable {
}