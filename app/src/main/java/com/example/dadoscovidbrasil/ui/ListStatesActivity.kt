package com.example.dadoscovidbrasil.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dadoscovidbrasil.R
import com.example.dadoscovidbrasil.adapters.ListStateAdapter
import com.example.dadoscovidbrasil.repositories.Covid19BrazilServiceAPI
import com.example.dadoscovidbrasil.services.Covid19BrazilService
import com.example.dadoscovidbrasil.usecases.GetStateSummary
import kotlinx.android.synthetic.main.activity_list_states.*
import org.koin.android.ext.android.get

class ListStatesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_states)

        val covid19BrazilServiceAPI: Covid19BrazilServiceAPI = get()
        val covid19BrazilService: Covid19BrazilService = covid19BrazilServiceAPI.getCovid19BrazilService()
        val getStateSummary = GetStateSummary(covid19BrazilService)

        getStateSummary.execute()
        getStateSummary.stateSummaryData.observe(this, Observer { stateSummary ->
            run {
                val recyclerView = state_list_recyclerview
                recyclerView.adapter = ListStateAdapter(stateSummary.data, this)
                val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                recyclerView.layoutManager = layoutManager
            }
        })
    }
}