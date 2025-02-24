package com.example.proyecto1activity1

// Preguntas.kt

data class Respuesta(val texto: String, val correcta: Boolean)
data class Pregunta(val texto: String, val respuestas: List<Respuesta>)
data class Categoria(val nombre: String, val imagen: String, val preguntas: List<Pregunta>)

fun obtenerPreguntas(): List<Categoria> {
    return listOf(
        Categoria(
            nombre = "Sherlock Holmes",
            imagen = "geografia.jpg",
            preguntas = listOf(
                Pregunta(
                    texto = "¿Cuál es la capital de Francia?",
                    respuestas = listOf(
                        Respuesta("París", true),
                        Respuesta("Londres", false),
                        Respuesta("Madrid", false),
                        Respuesta("Berlín", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                )
            )
        ),
        Categoria(
            nombre = "Harry Potter",
            imagen = "historia.jpg",
            preguntas = listOf(
                Pregunta(
                    texto = "¿Quién fue el primer presidente de EE. UU.?",
                    respuestas = listOf(
                        Respuesta("George Washington", true),
                        Respuesta("Abraham Lincoln", false),
                        Respuesta("Thomas Jefferson", false),
                        Respuesta("Theodore Roosevelt", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                )
            )
        ),
        Categoria(
            nombre = "Poesia",
            imagen = "historia.jpg",
            preguntas = listOf(
                Pregunta(
                    texto = "¿Quién fue el primer presidente de EE. UU.?",
                    respuestas = listOf(
                        Respuesta("George Washington", true),
                        Respuesta("Abraham Lincoln", false),
                        Respuesta("Thomas Jefferson", false),
                        Respuesta("Theodore Roosevelt", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                )
            )
        ),
        Categoria(
            nombre = "Aviones",
            imagen = "historia.jpg",
            preguntas = listOf(
                Pregunta(
                    texto = "¿Quién fue el primer presidente de EE. UU.?",
                    respuestas = listOf(
                        Respuesta("George Washington", true),
                        Respuesta("Abraham Lincoln", false),
                        Respuesta("Thomas Jefferson", false),
                        Respuesta("Theodore Roosevelt", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                )
            )
        ),
        Categoria(
            nombre = "Flores",
            imagen = "historia.jpg",
            preguntas = listOf(
                Pregunta(
                    texto = "¿Quién fue el primer presidente de EE. UU.?",
                    respuestas = listOf(
                        Respuesta("George Washington", true),
                        Respuesta("Abraham Lincoln", false),
                        Respuesta("Thomas Jefferson", false),
                        Respuesta("Theodore Roosevelt", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "¿Cuál es el río más largo del mundo?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                )
            )
        )
    )
}
