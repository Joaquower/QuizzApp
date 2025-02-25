package com.example.proyecto1activity1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadosActivity : AppCompatActivity() {

    private lateinit var txtRespuestasCorrectas: TextView
    private lateinit var txtTotalPreguntas: TextView

    private lateinit var txtResultadof: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        // Referencias a los TextViews
        txtRespuestasCorrectas = findViewById(R.id.txtRespuestasCorrectas)
        txtTotalPreguntas = findViewById(R.id.txtTotalPreguntas)

        txtResultadof = findViewById(R.id.txtResultadof)

        // Obtener los datos del Intent
        val respuestasCorrectas = intent.getIntExtra("respuestasCorrectas", 0)
        val totalPreguntas = intent.getIntExtra("totalPreguntas", 0)

        // Obtener intents de dani
        val totalpistas = intent.getIntExtra("totalpistas",0)
        val pistasusadas = intent.getIntExtra("pistasusadas", 0)


        // Varible de calculo
        val sumatoria = respuestasCorrectas

        val sumatoriamenospistas = sumatoria - pistasusadas

        val pistasnousadas = totalpistas / 2

        val sumatoriaplospistasnousadas = sumatoriamenospistas  + pistasnousadas





        // Actualizar los TextViews con los datos recibidos
        txtRespuestasCorrectas.text = "Respuestas correctas: $respuestasCorrectas"
        txtTotalPreguntas.text = "Total de preguntas: $totalPreguntas"
        txtResultadof.text = "Resultado final: $txtResultadof"
    }

    fun onRegresarClick(view: View) {
        finish()
    }
}
