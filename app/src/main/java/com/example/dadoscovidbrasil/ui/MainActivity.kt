package com.example.dadoscovidbrasil.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dadoscovidbrasil.R
import com.example.dadoscovidbrasil.models.Country
import com.example.dadoscovidbrasil.models.CountrySummary
import com.example.dadoscovidbrasil.repositories.Covid19BrazilServiceAPI
import com.example.dadoscovidbrasil.services.Covid19BrazilService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.get
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private val nf: NumberFormat = NumberFormat.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val countryValue: TextView = findViewById(R.id.country_value)
        val casesValue: TextView = findViewById(R.id.cases_value)
        val confirmedValue: TextView = findViewById(R.id.confirmed_value)
        val deathsValue: TextView = findViewById(R.id.deaths_value)
        val recoveredValue: TextView = findViewById(R.id.recovered_value)

        val covid19BrazilServiceAPI: Covid19BrazilServiceAPI = get()
        val covid19BrazilService: Covid19BrazilService = covid19BrazilServiceAPI.getCovid19BrazilService()

        CoroutineScope(Dispatchers.IO).launch {
            val request = covid19BrazilService.getCountrySummary("brazil")

            withContext(Dispatchers.IO) {
                try {
                    val response = request.await()
                    val any = if (response.isSuccessful) {
                        var result: CountrySummary? = response.body()
                        val country: Country = result!!.data
                        Log.d("MainActivity", country.toString())
                        countryValue.text = country.country
                        casesValue.text = nf.format(country.cases)
                        confirmedValue.text = nf.format(country.confirmed)
                        deathsValue.text = nf.format(country.deaths)
                        recoveredValue.text = nf.format(country.recovered)
                    } else {
                        //Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT)
                        Log.d("MainActivity", "Error: ${response.code()}")
                    }
                    any
                } catch (e: Exception) {
                    //Toast.makeText(this@MainActivity, "Exception", Toast.LENGTH_SHORT)
                    Log.d("MainActivity", "Exception ${e.message}")
                }
            }
        }
    }
}