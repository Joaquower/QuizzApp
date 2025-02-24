package com.example.proyecto1activity1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.SeekBar
import android.widget.Spinner

class OpcionesActivity : Activity() {

    private lateinit var spinnerDificultad: Spinner
    private lateinit var seekBarPistas: SeekBar
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        spinnerDificultad = findViewById(R.id.spinnerDificultad)
        seekBarPistas = findViewById(R.id.seekBarPistas)
        btnGuardar = findViewById(R.id.btnGuardar)

        // Cargar los valores en el Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.dificultades, // Asegúrate de tener este array en strings.xml
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDificultad.adapter = adapter

        // Obtener los valores pasados desde MainActivity
        val dificultad = intent.getStringExtra("dificultad") ?: "FACIL"
        val pistas = intent.getIntExtra("pistas", 3)

        // Establecer la selección del Spinner según la dificultad recibida
        val dificultadPosition = when (dificultad) {
            "FACIL" -> 0
            "MEDIO" -> 1
            "DIFICIL" -> 2
            else -> 0
        }
        spinnerDificultad.setSelection(dificultadPosition)

        // Establecer el valor de las pistas
        seekBarPistas.progress = pistas

        btnGuardar.setOnClickListener {
            val dificultadSeleccionada = spinnerDificultad.selectedItem.toString()
            val pistasSeleccionadas = seekBarPistas.progress

            val intent = Intent()
            intent.putExtra("dificultad", dificultadSeleccionada)
            intent.putExtra("pistas", pistasSeleccionadas)

            setResult(RESULT_OK, intent)
            finish() // Cerrar la actividad y devolver los resultados
        }
    }
}
