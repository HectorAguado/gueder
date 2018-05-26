package com.haguado.gueder.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.haguado.gueder.R
import com.haguado.gueder.fragment.CityListFragment
import com.haguado.gueder.model.City


class ForecastActivity : AppCompatActivity(), CityListFragment.OnCitySelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)


        // Averiguamos qué interfaz hemos cargado.
        // Preguntando si en la interfaz tenemos un FramLayout concreto
        if (findViewById<ViewGroup>(R.id.city_list_fragment) != null){
            if (supportFragmentManager.findFragmentById(R.id.city_list_fragment) == null){
                // añadimos el fragment de forma dinámica
                val fragment = CityListFragment.newInstance()

                supportFragmentManager.beginTransaction()
                        .add(R.id.city_list_fragment, fragment)
                        .commit()
            }

        }

        if(findViewById<ViewGroup>(R.id.))
        //


//        // Comprobamos primero que no tenemos ya añadido el fragment a nuestra jerarquía
//        if (supportFragmentManager.findFragmentById((R.id.city_list)) == null) {
//            // Añadimos fragment de forma dinámica
//            val fragment = CityListFragment.newInstance()
//
//            supportFragmentManager.beginTransaction()
//                    .add(R.id.city_list_fragment, fragment) // mete el fragment en el hueco que le he dejado en la vista
//                    .commit() // lo muestra en pantalla
//        }
    }
    override fun onCitySelected(city: City, position: Int) {
        val intent = CityPagerActivity.intent(this, position)
        startActivity(intent)
    }

}
//
//    companion object {
//        val TAG = ForecastActivity::class.java.canonicalName
//    }
//
//    val REQUEST_SETTINGS = 1
//
//    val PREFERENCE_UNITS = "UNITS"
//
//    var forecast: Forecast? = null
//        set(value) {
//            field = value
//
//            if (value != null) {
//                forecast_image.setImageResource(value.icon)
//                forecast_description.text = value.description
//
//                updateTemperatureView()
//                humidity.text = getString(R.string.humidity_format, value.humidity)
//            }
//        }
//
//    val units: TemperatureUnit
//        get() = when(PreferenceManager.getDefaultSharedPreferences(this)
//                .getInt(PREFERENCE_UNITS, TemperatureUnit.CELSIUS.ordinal)) {
//            TemperatureUnit.CELSIUS.ordinal -> TemperatureUnit.CELSIUS
//            else -> TemperatureUnit.FAHRENHEIT
//        }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_forecast)
//
//        forecast = Forecast(
//                25f,
//                10f,
//                35f,
//                "Soleado con alguna nube",
//                R.drawable.ico_01)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.activity_forecast, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item?.itemId) {
//            R.id.menu_show_settings -> {
//                // Lanzaremos la pantalla de ajustes, indicando que nos devolverá datos
//                startActivityForResult(
//                        SettingsActivity.intent(this, units),
//                        REQUEST_SETTINGS)
//
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        when (requestCode) {
//            REQUEST_SETTINGS -> {
//                if (resultCode == Activity.RESULT_OK && data != null) {
//                    // Volvemos de settings con datos sobre las unidades elegidas por el usuario
//                    val newUnits = data.getSerializableExtra(SettingsActivity.EXTRA_UNITS) as TemperatureUnit
//                    val oldUnits = units
//
//                    // Guardamos las preferencias del usuario
//                    PreferenceManager.getDefaultSharedPreferences(this)
//                            .edit()
//                            .putInt(PREFERENCE_UNITS, newUnits.ordinal)
//                            .apply()
//
//                    // Actualizo la interfaz con las nuevas unidades
//                    updateTemperatureView()
//
//                    val newUnitsString = if (newUnits == TemperatureUnit.CELSIUS) "Usuario seleccionó Celsius"
//                        else "Usuario seleccionó Fahrenheit"
////                    Toast.makeText(this, newUnitsString, Toast.LENGTH_LONG).show()
//                    Snackbar.make(findViewById<View>(android.R.id.content), newUnitsString, Snackbar.LENGTH_LONG)
//                            .setAction("Deshacer", View.OnClickListener {
//                                PreferenceManager.getDefaultSharedPreferences(this)
//                                        .edit()
//                                        .putInt(PREFERENCE_UNITS, oldUnits.ordinal)
//                                        .apply()
//                                // Actualizo la interfaz para restaurar las unidades viejas
//                                updateTemperatureView()
//                            })
//                            .show()
//                }
//            }
//        }
//    }
//
//    // Aquí actualizaremos la interfaz con las temperaturas
//    fun updateTemperatureView() {
//        val unitsString = units2String()
//        max_temp.text = getString(R.string.max_temp_format, forecast?.getMaxTemp(units)) + unitsString
//        min_temp.text = getString(R.string.min_temp_format, forecast?.getMinTemp(units)) + unitsString
//    }
//
//    fun units2String() = if (units == TemperatureUnit.CELSIUS) "C"
//    else "F"


//}
