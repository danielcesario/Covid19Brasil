package com.example.dadoscovidbrasil.services

import com.example.dadoscovidbrasil.models.CountrySummary
import com.example.dadoscovidbrasil.models.StateSummary
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Covid19BrazilService {
    @GET("v1/{country}")
    fun getCountrySummary(@Path("country") country: String): Deferred<Response<CountrySummary>>

    @GET("v1")
    fun getStateSummary(): Deferred<Response<StateSummary>>
}