package com.example.forecastapp.userinterface.weather.nextdays.nextdaysweather

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.forecastapp.R

class NextDaysWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            NextDaysWeatherFragment()
    }

    private lateinit var viewModel: NextDaysWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.next_days_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NextDaysWeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
