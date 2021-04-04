package com.example.dadoscovidbrasil.repositories

import com.example.dadoscovidbrasil.services.Covid19BrazilService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Covid19BrazilServiceAPI {

    fun getCovid19BrazilService() : Covid19BrazilService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://covid19-brazil-api.now.sh/api/report/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit.create(Covid19BrazilService::class.java)
    }
}