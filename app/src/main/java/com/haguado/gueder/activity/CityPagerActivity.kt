package com.haguado.gueder.activity

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v13.app.FragmentPagerAdapter
import com.haguado.gueder.R
import com.haguado.gueder.fragment.ForecastFragment
import com.haguado.gueder.model.Cities
import kotlinx.android.synthetic.main.activity_city_pager.*

class CityPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_pager)
        val cities = Cities()

        val adapter = object: FragmentPagerAdapter(fragmentManager){
            override fun getItem(position: Int): Fragment {
                return ForecastFragment.newInstance(cities.getCity(position))
            }

            override fun getCount(): Int {
                return cities.count
            }

//            override fun getPageTitle(position: Int): CharSequence? {
//                return
//            }

        }




        view_pager.adapter = adapter
    }
}
