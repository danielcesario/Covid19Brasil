package com.example.dadoscovidbrasil.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.dadoscovidbrasil.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        about_page_text_project.text = "Esta aplicação foi desenvolvida para estudo da plataforma Android utilizando Kotlin e alguns frameworks como: Koin e Retrofit.\n\n" +
                "A aplicação traz informações atualizadas sobre os casos de Corona Vírus no Brasil e em seus estados com base na API pública:\ncovid19-brazil-api.now.sh\n\n"+
                "Você pode acessar todo o código fonte da aplicação e contribuir pelo GitHub do projeto:\ngithub.com/danielcesario/Covid19BrasilApp"

        about_page_text_project.movementMethod = ScrollingMovementMethod()
    }
}