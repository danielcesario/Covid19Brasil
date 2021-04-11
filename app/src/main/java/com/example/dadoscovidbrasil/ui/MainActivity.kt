package com.example.dadoscovidbrasil.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dadoscovidbrasil.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        country_card.setOnClickListener {
            val intent = Intent(this, CountryActivity::class.java)
            startActivity(intent)
        }

        state_card.setOnClickListener {
            val intent = Intent(this, ListStatesActivity::class.java)
            startActivity(intent)
        }

        about_card.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}