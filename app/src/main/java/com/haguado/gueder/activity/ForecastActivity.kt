package com.haguado.gueder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
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