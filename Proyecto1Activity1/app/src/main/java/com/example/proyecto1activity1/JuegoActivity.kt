package com.example.proyecto1activity1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

data class RespuestaEstado(val preguntaIndex: Int, val fueCorrecta: Boolean)

class JuegoActivity : AppCompatActivity() {

    private lateinit var categorias: List<Categoria>
    private var preguntas: List<Pregunta> = emptyList()
    private var preguntaActual = 0
    private var preguntasContestadas = mutableSetOf<RespuestaEstado>()
    private var pistasDisponibles = 3
    private var respuestasCorrectasConsecutivas = 0
    private var respuestasCorrectas = 0
    private var totalPreguntas = 10
    private var dificultad: String = ""

    private lateinit var preguntaTextView: TextView
    private lateinit var temaImageView: ImageView
    private lateinit var btnRespuesta1: Button
    private lateinit var btnRespuesta2: Button
    private lateinit var btnRespuesta3: Button
    private lateinit var btnRespuesta4: Button
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button
    private lateinit var btnPista: Button
    private lateinit var puntosTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        // Cargar la dificultad y el número de pistas desde el Intent
        dificultad = intent.getStringExtra("dificultad") ?: "FACIL"
        pistasDisponibles = intent.getIntExtra("pistas", 3)

        // Inicialización de las vistas
        categorias = obtenerPreguntas()
        preguntas = obtenerPreguntasAleatorias()

        preguntaTextView = findViewById(R.id.preguntaTextView)
        temaImageView = findViewById(R.id.temaImageView)
        btnRespuesta1 = findViewById(R.id.btnRespuesta1)
        btnRespuesta2 = findViewById(R.id.btnRespuesta2)
        btnRespuesta3 = findViewById(R.id.btnRespuesta3)
        btnRespuesta4 = findViewById(R.id.btnRespuesta4)
        btnPrev = findViewById(R.id.btnPrev)
        btnNext = findViewById(R.id.btnNext)
        btnPista = findViewById(R.id.btnPista)
        puntosTextView = findViewById(R.id.puntosTextView)

        // Mostrar la cantidad de pistas desde el principio
        puntosTextView.text = "Pistas: $pistasDisponibles"

        mostrarPregunta()

        btnNext.setOnClickListener {
            preguntaActual = (preguntaActual + 1) % preguntas.size
            mostrarPregunta()
        }

        btnPrev.setOnClickListener {
            preguntaActual = if (preguntaActual == 0) preguntas.size - 1 else preguntaActual - 1
            mostrarPregunta()
        }

        btnPista.setOnClickListener {
            if (pistasDisponibles > 0) aplicarPista()
        }
    }

    private fun mostrarPregunta() {
        val pregunta = preguntas[preguntaActual]
        preguntaTextView.text = pregunta.texto

        val categoriaNombre = obtenerCategoriaDePregunta(pregunta, categorias)
        val categoria = categorias.find { it.nombre == categoriaNombre } ?: categorias[0]
        val imagenId = resources.getIdentifier(categoria.imagen, "drawable", packageName)
        temaImageView.setImageResource(imagenId)

        // Obtener las respuestas (correctas e incorrectas)
        val respuestasCorrectas = pregunta.respuestas.filter { it.correcta }
        val respuestasIncorrectas = pregunta.respuestas.filter { !it.correcta }

        // Respuestas que se van a mostrar
        val respuestasLimitadas: List<Respuesta> = when (dificultad) {
            "FACIL" -> {
                val respuestasSeleccionadas = mutableListOf<Respuesta>()
                respuestasSeleccionadas.add(respuestasCorrectas.random()) // Agregar 1 correcta
                respuestasSeleccionadas.addAll(respuestasIncorrectas.shuffled().take(1)) // Agregar 1 incorrecta
                respuestasSeleccionadas.shuffled() // Mezclar respuestas
            }
            "MEDIO" -> {
                val respuestasSeleccionadas = mutableListOf<Respuesta>()
                respuestasSeleccionadas.add(respuestasCorrectas.random()) // Agregar 1 correcta
                respuestasSeleccionadas.addAll(respuestasIncorrectas.shuffled().take(2)) // Agregar 2 incorrectas
                respuestasSeleccionadas.shuffled() // Mezclar respuestas
            }
            "DIFICIL" -> {
                (respuestasCorrectas + respuestasIncorrectas).shuffled().take(4)
            }
            else -> respuestasCorrectas + respuestasIncorrectas
        }

        val botones = listOf(btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4)
        botones.forEachIndexed { index, button ->
            if (index < respuestasLimitadas.size) {
                button.text = respuestasLimitadas[index].texto
                button.visibility = View.VISIBLE
                button.setBackgroundColor(Color.LTGRAY)
                button.isEnabled = !preguntasContestadas.any { it.preguntaIndex == preguntaActual }  // Deshabilita si ya fue contestada
                button.setOnClickListener { verificarRespuesta(respuestasLimitadas[index], button) }

                // Si la pregunta ya fue respondida, mostrar el color correspondiente en el fondo solo en la respuesta seleccionada
                val respuestaEstado = preguntasContestadas.find { it.preguntaIndex == preguntaActual }
                if (respuestaEstado != null && respuestaEstado.preguntaIndex == preguntaActual) {
                    // Pintar solo la respuesta seleccionada
                    if (button.text == respuestasLimitadas.find { it.correcta }?.texto) {
                        button.setBackgroundColor(Color.GREEN)
                    } else {
                        button.setBackgroundColor(Color.RED)
                    }
                }
            } else {
                button.visibility = View.GONE
            }
        }

        // Si es la última pregunta, ir a la actividad de resultados
        if (preguntaActual == preguntas.size - 1 && preguntasContestadas.size == preguntas.size) {
            terminarJuego()
        }
    }

    private fun verificarRespuesta(respuesta: Respuesta, botonSeleccionado: Button) {
        if (preguntasContestadas.any { it.preguntaIndex == preguntaActual }) return  // Evita respuestas repetidas

        val fueCorrecta = respuesta.correcta
        preguntasContestadas.add(RespuestaEstado(preguntaActual, fueCorrecta))

        if (fueCorrecta) {
            respuestasCorrectas++
            respuestasCorrectasConsecutivas++
            botonSeleccionado.setBackgroundColor(Color.GREEN)
            if (respuestasCorrectasConsecutivas % 2 == 0) pistasDisponibles++
            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show()
        } else {
            respuestasCorrectasConsecutivas = 0
            botonSeleccionado.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            marcarCorrecta()
        }

        deshabilitarBotones()
        puntosTextView.text = "Pistas: $pistasDisponibles"
    }

    private fun marcarCorrecta() {
        val pregunta = preguntas[preguntaActual]
        val botones = listOf(btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4)
        botones.forEach { boton ->
            if (boton.text == pregunta.respuestas.find { it.correcta }?.texto) {
                boton.setBackgroundColor(Color.GREEN)
            }
        }
    }

    private fun deshabilitarBotones() {
        val botones = listOf(btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4)
        botones.forEach { it.isEnabled = false }
    }

    private fun aplicarPista() {
        if (preguntasContestadas.any { it.preguntaIndex == preguntaActual }) return // No aplicar pistas a preguntas ya contestadas

        if (preguntas.size <= 2) {
            // Si quedan 2 preguntas o menos, responder automáticamente la pregunta
            val respuestaCorrecta = preguntas[preguntaActual].respuestas.find { it.correcta }
            val boton = listOf(btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4)
                .firstOrNull { it.text == respuestaCorrecta?.texto }
            boton?.setBackgroundColor(Color.GREEN)
            preguntasContestadas.add(RespuestaEstado(preguntaActual, true))
            respuestasCorrectas++
            deshabilitarBotones()
            Toast.makeText(this, "Pregunta contestada automáticamente.", Toast.LENGTH_SHORT).show()
        } else {
            pistasDisponibles--
            val pregunta = preguntas[preguntaActual]
            val respuestasIncorrectas = pregunta.respuestas.filter { !it.correcta }

            if (respuestasIncorrectas.size > 1) {
                val respuestaIncorrecta = respuestasIncorrectas.random()
                val botones = listOf(btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4)
                botones.firstOrNull { it.text == respuestaIncorrecta.texto }?.visibility = View.INVISIBLE
                Toast.makeText(this, "Pista aplicada", Toast.LENGTH_SHORT).show()
            }
            puntosTextView.text = "Pistas: $pistasDisponibles"
        }
    }

    private fun obtenerPreguntasAleatorias(): List<Pregunta> {
        val todasLasPreguntas = categorias.flatMap { it.preguntas }
        return todasLasPreguntas.shuffled().take(10)
    }

    private fun terminarJuego() {
        val intent = Intent(this, ResultadosActivity::class.java)
        intent.putExtra("respuestasCorrectas", respuestasCorrectas)
        intent.putExtra("totalPreguntas", totalPreguntas)
        startActivity(intent)
        finish()
    }

    private fun obtenerCategoriaDePregunta(pregunta: Pregunta, categorias: List<Categoria>): String? {
        for (categoria in categorias) {
            if (categoria.preguntas.contains(pregunta)) {
                return categoria.nombre
            }
        }
        return null
    }
}
