package com.example.dadoscovidbrasil.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.dadoscovidbrasil.R
import com.example.dadoscovidbrasil.models.CountrySummary
import com.example.dadoscovidbrasil.repositories.Covid19BrazilServiceAPI
import com.example.dadoscovidbrasil.services.Covid19BrazilService
import com.example.dadoscovidbrasil.usecases.GetCountrySummary
import kotlinx.android.synthetic.main.activity_country.*
import org.koin.android.ext.android.get
import java.text.NumberFormat

class CountryActivity : AppCompatActivity() {
    private val nf: NumberFormat = NumberFormat.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_country)

        val covid19BrazilServiceAPI: Covid19BrazilServiceAPI = get()
        val covid19BrazilService: Covid19BrazilService = covid19BrazilServiceAPI.getCovid19BrazilService()
        val getCountrySummary = GetCountrySummary(covid19BrazilService)

        getCountrySummary.execute("brazil")
        getCountrySummary.countrySummaryData.observe(this, Observer { countrySummary -> fillMainCard(countrySummary) })
    }

    fun fillMainCard(countrySummary: CountrySummary) {
        Log.d("CountryActivity", countrySummary.data.toString())
        country_value.text = countrySummary.data.country
        cases_value.text = nf.format(countrySummary.data.cases)
        confirmed_value.text = nf.format(countrySummary.data.confirmed)
        deaths_value.text = nf.format(countrySummary.data.deaths)
        recovered_value.text = nf.format(countrySummary.data.recovered)
    }
}