package com.haguado.gueder.fragment


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.haguado.gueder.R
import com.haguado.gueder.model.Cities
import com.haguado.gueder.model.City
import kotlinx.android.synthetic.main.fragment_city_list.*


class CityListFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = CityListFragment()
    }

    private var onCitySelectedListener: OnCitySelectedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val cities = Cities()

        val adapter = ArrayAdapter<City>(
                activity,
                android.R.layout.simple_list_item_1,
                Cities.toArray())

        city_list.adapter = adapter

        city_list.setOnItemClickListener {
            adapterView, ciew, index, l ->
            // Avisamos al listener que una ciudad ha sido seleccionada
            onCitySelectedListener?.onCitySelected(Cities[index], index)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context as Activity)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    private fun commonAttach(activity: Activity?){
        if (activity is OnCitySelectedListener){
            onCitySelectedListener = activity
        }else {
            onCitySelectedListener = null
        }
    }

    override fun onDetach() {
        super.onDetach()
        onCitySelectedListener = null
    }

    //INTERFACE
    interface OnCitySelectedListener{
        fun onCitySelected(city: City, position: Int)
    }

}
