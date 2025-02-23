package com.example.proyecto1activity1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnJugar: Button
    private lateinit var btnOpciones: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btnJugar = findViewById(R.id.btn_Jugar)
    btnOpciones = findViewById(R.id.btn_Opciones)
    }
}
