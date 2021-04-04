package com.example.dadoscovidbrasil.models

data class CountrySummary (
    val data: Country
)

data class Country (
    val country: String,
    val cases: Int,
    val confirmed: Int,
    val deaths: Int,
    val recovered: Int,
    val updated_at: String
)