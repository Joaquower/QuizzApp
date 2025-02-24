package com.example.proyecto1activity1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class JuegoActivity : AppCompatActivity() {

    private lateinit var categorias: List<Categoria>
    private var preguntas: List<Pregunta> = emptyList()
    private var preguntaActual = 0
    private var preguntasContestadas = mutableListOf<Int>() // Guardar preguntas contestadas
    private var pistasDisponibles = 3
    private var respuestasCorrectasConsecutivas = 0
    private var respuestasCorrectas = 0 // Cantidad de respuestas correctas
    private var totalPreguntas = 10 // Número total de preguntas a responder
    private var dificultad: String = "" // FACIL, NORMAL, DIFICIL

    // UI elements
    private lateinit var preguntaTextView: TextView
    private lateinit var temaImageView: ImageView // Para la imagen del tema
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

        // Recibir datos desde MainActivity
        val intent = intent
        dificultad = intent.getStringExtra("dificultad") ?: "FACIL"
        pistasDisponibles = intent.getIntExtra("pistas", 3)  // Recupera las pistas, 3 es el valor por defecto

        // Inicializar las preguntas
        categorias = obtenerPreguntas()
        preguntas = obtenerPreguntasAleatorias()

        // Inicializar vistas
        preguntaTextView = findViewById(R.id.preguntaTextView)
        temaImageView = findViewById(R.id.temaImageView) // ImageView para la imagen del tema
        btnRespuesta1 = findViewById(R.id.btnRespuesta1)
        btnRespuesta2 = findViewById(R.id.btnRespuesta2)
        btnRespuesta3 = findViewById(R.id.btnRespuesta3)
        btnRespuesta4 = findViewById(R.id.btnRespuesta4)
        btnPrev = findViewById(R.id.btnPrev)
        btnNext = findViewById(R.id.btnNext)
        btnPista = findViewById(R.id.btnPista)
        puntosTextView = findViewById(R.id.puntosTextView)

        // Mostrar la primera pregunta
        mostrarPregunta()

        // Lógica del botón Next
        btnNext.setOnClickListener {
            if (preguntaActual < preguntas.size - 1) {
                preguntaActual++
                mostrarPregunta()
            }
        }

        // Lógica del botón Prev
        btnPrev.setOnClickListener {
            if (preguntaActual > 0) {
                preguntaActual--
                mostrarPregunta()
            }
        }

        // Lógica del botón Pista
        btnPista.setOnClickListener {
            if (pistasDisponibles > 0) {
                aplicarPista()
            }
        }
    }

    private fun mostrarPregunta() {
        val pregunta = preguntas[preguntaActual]
        preguntaTextView.text = pregunta.texto

        // Mostrar la imagen del tema
        val imagenId = resources.getIdentifier(pregunta.temaImagen, "drawable", packageName)
        temaImageView.setImageResource(imagenId)

        // Mostrar las respuestas dependiendo de la dificultad
        val respuestas = pregunta.respuestas.shuffled()
        val respuestasLimitadas = when (dificultad) {
            "FACIL" -> respuestas.take(2)
            "NORMAL" -> respuestas.take(3)
            "DIFICIL" -> respuestas.take(4)
            else -> respuestas
        }

        btnRespuesta1.text = respuestasLimitadas[0].texto
        btnRespuesta2.text = respuestasLimitadas.getOrNull(1)?.texto
        btnRespuesta3.text = respuestasLimitadas.getOrNull(2)?.texto
        btnRespuesta4.text = respuestasLimitadas.getOrNull(3)?.texto

        // Deshabilitar las respuestas si ya se contestó la pregunta
        if (preguntasContestadas.contains(preguntaActual)) {
            btnRespuesta1.isEnabled = false
            btnRespuesta2.isEnabled = false
            btnRespuesta3.isEnabled = false
            btnRespuesta4.isEnabled = false
        } else {
            // Si no está contestada, habilitar botones
            btnRespuesta1.isEnabled = true
            btnRespuesta2.isEnabled = true
            btnRespuesta3.isEnabled = true
            btnRespuesta4.isEnabled = true

            // Lógica para verificar la respuesta seleccionada
            btnRespuesta1.setOnClickListener { verificarRespuesta(respuestasLimitadas[0]) }
            btnRespuesta2.setOnClickListener { verificarRespuesta(respuestasLimitadas[1]) }
            btnRespuesta3.setOnClickListener { verificarRespuesta(respuestasLimitadas[2]) }
            btnRespuesta4.setOnClickListener { verificarRespuesta(respuestasLimitadas[3]) }
        }
    }

    private fun verificarRespuesta(respuesta: Respuesta) {
        // Marcar la pregunta como contestada
        preguntasContestadas.add(preguntaActual)

        // Verificar si la respuesta es correcta
        if (respuesta.correcta) {
            respuestasCorrectas++
            respuestasCorrectasConsecutivas++
            if (respuestasCorrectasConsecutivas % 2 == 0) {
                pistasDisponibles++ // Bonificar una pista por cada dos respuestas correctas consecutivas
            }
            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show()
        } else {
            respuestasCorrectasConsecutivas = 0
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }

        // Deshabilitar los botones después de responder
        btnRespuesta1.isEnabled = false
        btnRespuesta2.isEnabled = false
        btnRespuesta3.isEnabled = false
        btnRespuesta4.isEnabled = false

        // Actualizar la cantidad de pistas disponibles y mostrarla
        puntosTextView.text = "Pistas: $pistasDisponibles"
    }

    private fun aplicarPista() {
        if (pistasDisponibles > 0) {
            pistasDisponibles--

            // Aquí aplicamos la lógica para eliminar una respuesta incorrecta
            // Si hay más de dos respuestas, eliminamos una incorrecta
            val pregunta = preguntas[preguntaActual]
            val respuestasIncorrectas = pregunta.respuestas.filter { !it.correcta }
            if (respuestasIncorrectas.size > 1) {
                val respuestaIncorrecta = respuestasIncorrectas.random()
                // Aquí marcarías la respuesta como eliminada o la ocultarías
                // (Por ejemplo, deshabilitar el botón correspondiente)
                Toast.makeText(this, "Pista aplicada, respuesta incorrecta eliminada", Toast.LENGTH_SHORT).show()
            } else {
                // Si solo quedan dos respuestas, la pista responde la pregunta
                Toast.makeText(this, "Pista aplicada, respuesta correcta revelada", Toast.LENGTH_SHORT).show()
                // Aquí, revelas la respuesta correcta
            }

            // Actualizar la cantidad de pistas
            puntosTextView.text = "Pistas: $pistasDisponibles"
        }
    }

    private fun obtenerPreguntasAleatorias(): List<Pregunta> {
        // Seleccionamos 10 preguntas aleatorias de un total de 25
        val todasLasPreguntas = mutableListOf<Pregunta>()
        categorias.forEach { categoria ->
            todasLasPreguntas.addAll(categoria.preguntas)
        }
        return todasLasPreguntas.shuffled().take(10)
    }

    // Enviar los resultados de vuelta a MainActivity
    private fun enviarResultados() {
        val intent = Intent()
        intent.putExtra("respuestasCorrectas", respuestasCorrectas)  // Pasar el número de respuestas correctas
        intent.putExtra("totalPreguntas", totalPreguntas)  // Pasar el número total de preguntas
        setResult(RESULT_OK, intent)  // Devolver los resultados a MainActivity
        finish()  // Finalizar la actividad
    }

    // Llamar a esta función cuando el jugador termine las preguntas o al hacer clic en un botón "Terminar"
    private fun terminarJuego() {
        enviarResultados()
    }
}
