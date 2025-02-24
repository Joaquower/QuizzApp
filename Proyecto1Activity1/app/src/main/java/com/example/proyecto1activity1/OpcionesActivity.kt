package com.example.proyecto1activity1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*

class OpcionesActivity : Activity() {

    private lateinit var spinnerDificultad: Spinner
    private lateinit var seekBarPistas: SeekBar
    private lateinit var btnGuardar: Button
    private lateinit var textViewPistasValor: TextView  // Nuevo TextView para mostrar el valor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        spinnerDificultad = findViewById(R.id.spinnerDificultad)
        seekBarPistas = findViewById(R.id.seekBarPistas)
        btnGuardar = findViewById(R.id.btnGuardar)
        textViewPistasValor = findViewById(R.id.textViewPistasValor) // Referencia al nuevo TextView

        // Cargar los valores en el Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.dificultades,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDificultad.adapter = adapter

        // Obtener valores pasados desde MainActivity
        val dificultad = intent.getStringExtra("dificultad") ?: "FACIL"
        val pistas = intent.getIntExtra("pistas", 3)

        // Establecer selección del Spinner
        val dificultadPosition = when (dificultad) {
            "FACIL" -> 0
            "MEDIO" -> 1
            "DIFICIL" -> 2
            else -> 0
        }
        spinnerDificultad.setSelection(dificultadPosition)

        // Establecer el valor inicial de las pistas en el SeekBar y el TextView
        seekBarPistas.progress = pistas
        textViewPistasValor.text = "Pistas: $pistas"

        // Listener para actualizar el TextView cuando el usuario mueva el SeekBar
        seekBarPistas.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewPistasValor.text = "Pistas: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Guardar configuración y regresar a MainActivity
        btnGuardar.setOnClickListener {
            val dificultadSeleccionada = spinnerDificultad.selectedItem.toString()
            val pistasSeleccionadas = seekBarPistas.progress

            val intent = Intent()
            intent.putExtra("dificultad", dificultadSeleccionada)
            intent.putExtra("pistas", pistasSeleccionadas)

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
