package com.example.proyecto1activity1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadosActivity : AppCompatActivity() {

    private lateinit var txtRespuestasCorrectas: TextView
    private lateinit var txtTotalPreguntas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        // Referencias a los TextViews
        txtRespuestasCorrectas = findViewById(R.id.txtRespuestasCorrectas)
        txtTotalPreguntas = findViewById(R.id.txtTotalPreguntas)

        // Obtener los datos del Intent
        val respuestasCorrectas = intent.getIntExtra("respuestasCorrectas", 0)
        val totalPreguntas = intent.getIntExtra("totalPreguntas", 0)

        // Actualizar los TextViews con los datos recibidos
        txtRespuestasCorrectas.text = "Respuestas correctas: $respuestasCorrectas"
        txtTotalPreguntas.text = "Total de preguntas: $totalPreguntas"
    }

    // Método para manejar el click en el botón "Regresar"
    fun onRegresarClick(view: View) {
        finish() // Cierra la Activity4 y regresa a la anterior
    }
}
