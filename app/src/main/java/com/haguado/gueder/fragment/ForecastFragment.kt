package com.haguado.gueder.fragment

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.view.*
import com.haguado.gueder.model.Forecast
import com.haguado.gueder.R
import com.haguado.gueder.model.TemperatureUnit
import com.haguado.gueder.activity.SettingsActivity
import com.haguado.gueder.model.City
import kotlinx.android.synthetic.main.fragment_forecast.*

class ForecastFragment: Fragment() {

    companion object {

        val ARG_CITY = "ARG_CITY"

        fun newInstance(city: City): Fragment {
            //Nos creamos el fragment
            val fragment = ForecastFragment()

            // Nos creamos los argumentos del fragment
            val arguments = Bundle()
            arguments.putSerializable(ARG_CITY, city)

            // Asignamos los argumentos al fragment
            fragment.arguments = arguments

            // Devolvemos el fragment
            return fragment
        }
    }

    val REQUEST_SETTINGS = 1

    val PREFERENCE_UNITS = "UNITS"

    var forecast: Forecast? = null
        set(value) {
            field = value

            if (value != null) {
                forecast_image.setImageResource(value.icon)
                forecast_description.text = value.description

                updateTemperatureView()
                humidity.text = getString(R.string.humidity_format, value.humidity)
            }
        }

    val units: TemperatureUnit
        get() = when(PreferenceManager.getDefaultSharedPreferences(activity)
                .getInt(PREFERENCE_UNITS, TemperatureUnit.CELSIUS.ordinal)) {
            TemperatureUnit.CELSIUS.ordinal -> TemperatureUnit.CELSIUS
            else -> TemperatureUnit.FAHRENHEIT
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // indicar que este fragment publica opciones de menú
        setHasOptionsMenu(true)
    }
    //cargar la interfaz de este fragment
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_forecast, container, false)!!
    }
    //aqui ya podemos tocar la interfaz, y podemos acceder al setter
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val city:City = arguments.getSerializable(ARG_CITY) as City
            forecast = city.forecast
        }
//        forecast = Forecast(
//                25f,
//                10f,
//                35f,
//                "Soleado con alguna nube",
//                R.drawable.ico_01)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.activity_forecast, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_show_settings -> {
                // Lanzaremos la pantalla de ajustes, indicando que nos devolverá datos
                startActivityForResult(
                        SettingsActivity.intent(activity, units),
                        REQUEST_SETTINGS)

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        when (requestCode) {
            REQUEST_SETTINGS -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    // Volvemos de settings con datos sobre las unidades elegidas por el usuario
                    val newUnits = data.getSerializableExtra(SettingsActivity.EXTRA_UNITS) as TemperatureUnit
                    val oldUnits = units

                    // Guardamos las preferencias del usuario
                    PreferenceManager.getDefaultSharedPreferences(activity)
                            .edit()
                            .putInt(PREFERENCE_UNITS, newUnits.ordinal)
                            .apply()

                    // Actualizo la interfaz con las nuevas unidades
                    updateTemperatureView()

                    val newUnitsString = if (newUnits == TemperatureUnit.CELSIUS) "Usuario seleccionó Celsius"
                    else "Usuario seleccionó Fahrenheit"
//                    Toast.makeText(this, newUnitsString, Toast.LENGTH_LONG).show()
                    Snackbar.make(view, newUnitsString, Snackbar.LENGTH_LONG)
                            .setAction("Deshacer", View.OnClickListener {
                                PreferenceManager.getDefaultSharedPreferences(activity)
                                        .edit()
                                        .putInt(PREFERENCE_UNITS, oldUnits.ordinal)
                                        .apply()
                                // Actualizo la interfaz para restaurar las unidades viejas
                                updateTemperatureView()
                            })
                            .show()
                }
            }
        }
    }
    // Aquí actualizaremos la interfaz con las temperaturas
    fun updateTemperatureView() {
        val unitsString = units2String()
        max_temp.text = getString(R.string.max_temp_format, forecast?.getMaxTemp(units)) + unitsString
        min_temp.text = getString(R.string.min_temp_format, forecast?.getMinTemp(units)) + unitsString
    }

    fun units2String() = if (units == TemperatureUnit.CELSIUS) "C"
    else "F"

}