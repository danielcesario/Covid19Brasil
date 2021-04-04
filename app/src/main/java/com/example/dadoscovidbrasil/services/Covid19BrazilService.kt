package com.example.dadoscovidbrasil.services

import com.example.dadoscovidbrasil.models.CountrySummary
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Covid19BrazilService {
    @GET("v1/{country}")
    fun getCountrySummary(@Path("country") country: String): Deferred<Response<CountrySummary>>
}