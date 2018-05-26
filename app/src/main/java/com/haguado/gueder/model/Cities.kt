package com.haguado.gueder.model

import com.haguado.gueder.R

//object, indicamos que se puede acceder a esta clase como si fuera un único objeto, osea, un SINGLETON
object Cities {

    private val cities: List<City> = listOf(
            City("Madrid", Forecast(25f, 10f, 35f, "Soleado con alguna nube", R.drawable.ico_02 )),
            City("Segovia", Forecast(36f, 23f, 19f, "sol a top", R.drawable.ico_01)),
            City("Quito", Forecast(30f, 15f, 40f, "Lluvia", R.drawable.ico_10))
    )

    val count
        get() = cities.size

    fun getCity(index: Int) = cities[index]

    operator fun get(index: Int) = cities[index]  // sobrecarga del operador corchete

    fun toArray() = cities.toTypedArray() // toTypedArray es un método de las listas para convertirla en un array

}