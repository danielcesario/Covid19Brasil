package com.example.dadoscovidbrasil.models

data class StateSummary(
    val data: List<State>
)

data class State(
    val uid: Int,
    val uf: String,
    val state: String,
    val cases: Int,
    val deaths: Int,
    val suspects: Int,
    val refuses: Int,
    val broadcast: Boolean,
    val comments: String,
    val datetime: String
)