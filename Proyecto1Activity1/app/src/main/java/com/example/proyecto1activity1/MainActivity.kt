package com.example.proyecto1activity1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnJugar: Button
    private lateinit var btnOpciones: Button

    private var dificultadSeleccionada = "FACIL"
    private var pistasDisponibles = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJugar = findViewById(R.id.btn_Jugar)
        btnOpciones = findViewById(R.id.btn_Opciones)

        btnOpciones.setOnClickListener {
            val intent = Intent(this, OpcionesActivity::class.java)

            // Enviar la configuración actual si no es nula
            intent.putExtra("dificultad", dificultadSeleccionada)
            intent.putExtra("pistas", pistasDisponibles)

            startActivityForResult(intent, 1)  // Abrimos OpcionesActivity y esperamos un resultado
        }

        btnJugar.setOnClickListener {
            val intent = Intent(this, JuegoActivity::class.java)
            intent.putExtra("dificultad", dificultadSeleccionada)
            intent.putExtra("pistas", pistasDisponibles)
            startActivity(intent)
        }
    }

    // Recibir los resultados desde OpcionesActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 1) {
            // Obtener los valores seleccionados en OpcionesActivity
            dificultadSeleccionada = data?.getStringExtra("dificultad") ?: "FACIL"
            pistasDisponibles = data?.getIntExtra("pistas", 3) ?: 3
        }
    }
}
