package com.example.dadoscovidbrasil.usecases

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dadoscovidbrasil.models.StateSummary
import com.example.dadoscovidbrasil.services.Covid19BrazilService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetStateSummary(private val covid19BrazilService: Covid19BrazilService) {
    val stateSummaryData = MutableLiveData<StateSummary>()

    fun execute() {
        CoroutineScope(Dispatchers.Main).launch {
            val request = covid19BrazilService.getStateSummary()
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        Log.d("GetStateSummary", "Success: ${response.body()}")
                        stateSummaryData.value = response.body()
                    } else {
                        Log.d("GetStateSummary", "Error: ${response.code()}")
                    }
                } catch (e: Exception) {
                    Log.d("GetStateSummary", "Exception ${e.message}")
                }
            }
        }
    }
}