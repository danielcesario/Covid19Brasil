package com.example.dadoscovidbrasil

import android.app.Application
import com.example.dadoscovidbrasil.repositories.Covid19BrazilServiceAPI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication: Application() {

    var listOfModules = module {
        single { Covid19BrazilServiceAPI() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //androidLogger()
            androidContext(this@MyApplication)
            modules(listOfModules)
        }
    }
}