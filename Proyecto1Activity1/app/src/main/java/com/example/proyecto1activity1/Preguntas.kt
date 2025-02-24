package com.example.proyecto1activity1

// Preguntas.kt

data class Respuesta(val texto: String, val correcta: Boolean)
data class Pregunta(val texto: String, val respuestas: List<Respuesta>)
data class Categoria(val nombre: String, val imagen: String, val preguntas: List<Pregunta>)

fun obtenerPreguntas(): List<Categoria> {
    return listOf(
        Categoria(
            nombre = "Sherlock Holmes",
            imagen = "historia2",
            preguntas = listOf(
                Pregunta(
                    texto = "¿En El sabueso de los Baskerville, qué objeto encuentra el Dr. Mortimer en la escena del crimen de Sir Charles Baskerville?",
                    respuestas = listOf(
                        Respuesta("Unas huellas de sabueso en el suelo.", true),
                        Respuesta("Un bastón con las iniciales H.B.", false),
                        Respuesta("Un zapato viejo de Sir Charles.", false),
                        Respuesta("Un guante de cuero negro.", false)
                    )
                ),
                Pregunta(
                    texto = "En Escándalo en Bohemia, ¿cómo logra Sherlock Holmes descubrir dónde Irene Adler esconde la fotografía?",
                    respuestas = listOf(
                        Respuesta("Provocando un incendio falso en su casa.", true),
                        Respuesta("Amenazándola con revelar un secreto suyo.", false),
                        Respuesta("Haciéndola reír para que mire involuntariamente hacia su escondite.", false),
                        Respuesta("Usando un perro rastreador que olfatea el documento.", false)
                    )
                ),
                Pregunta(
                    texto = "En La aventura de la Liga de los Pelirrojos, ¿qué trabajo ficticio le asignan al Sr. Wilson para mantenerlo ocupado?",
                    respuestas = listOf(
                        Respuesta("Escribir una enciclopedia de Londres.", true),
                        Respuesta("Restaurar documentos antiguos.", false),
                        Respuesta("Archivar expedientes en Scotland Yard.", false),
                        Respuesta("Catalogar libros en una biblioteca privada.", false)
                    )
                ),
                Pregunta(
                    texto = " En El signo de los cuatro, ¿cómo llega la perla a la señorita Morstan cada año?",
                    respuestas = listOf(
                        Respuesta("Llega cada año en un pequeño paquete sin remitente. ", true),
                        Respuesta("Es entregada personalmente por un hombre encapuchado.", false),
                        Respuesta("Se encuentra dentro de un libro enviado por correo.", false),
                        Respuesta("Aparece misteriosamente en su tocador cada mañana de su cumpleaños.", false)
                    )
                ),
                Pregunta(
                    texto = "En La aventura de la banda de lunares, ¿qué animal usa el Dr. Roylott para intentar asesinar a su hijastra?",
                    respuestas = listOf(
                        Respuesta("Una cobra india", true),
                        Respuesta("Un murciélago vampiro.", false),
                        Respuesta("Un escorpión venenoso.", false),
                        Respuesta("Una tarántula gigante.", false)
                    )
                )
            )
        ),
        Categoria(
            nombre = "Harry Potter",
            imagen = "harrypotter",
            preguntas = listOf(
                Pregunta(
                    texto = "En Harry Potter y la piedra filosofal, ¿qué tarea debe realizar Ron en el desafío del tablero de ajedrez gigante?",
                    respuestas = listOf(
                        Respuesta("Sacrificarse como un caballo para que Harry haga jaque mate. ", true),
                        Respuesta(" Jugar como un alfil y capturar a la reina enemiga.", false),
                        Respuesta("Moverse como un rey y llegar al otro extremo del tablero.", false),
                        Respuesta("Defender a Hermione de una torre enemiga.", false)
                    )
                ),
                Pregunta(
                    texto = "En Harry Potter y la cámara secreta, ¿qué dice la inscripción en la pared cuando la Cámara de los Secretos es abierta?",
                    respuestas = listOf(
                        Respuesta("Amazonas", true),
                        Respuesta("Nilo", false),
                        Respuesta("Yangtsé", false),
                        Respuesta("Misisipi", false)
                    )
                ),
                Pregunta(
                    texto = "En Harry Potter y la cámara secreta, ¿qué dice la inscripción en la pared cuando la Cámara de los Secretos es abierta?",
                    respuestas = listOf(
                        Respuesta("La Cámara de los Secretos ha sido abierta. Enemigos del heredero, temed", true),
                        Respuesta("El heredero de Slytherin ha regresado.", false),
                        Respuesta("El fin se acerca para los sangre sucia.", false),
                        Respuesta("Salve a Salazar Slytherin, la purga ha comenzado.", false)
                    )
                ),
                Pregunta(
                    texto = " En Harry Potter y el prisionero de Azkaban, ¿qué forma tiene el boggart de Neville Longbottom?",
                    respuestas = listOf(
                        Respuesta("Un profesor Snape aterrador.", true),
                        Respuesta("Un dementor.", false),
                        Respuesta("Una araña gigante.", false),
                        Respuesta("Su abuela furiosa.", false)
                    )
                ),
                Pregunta(
                    texto = "En Harry Potter y el cáliz de fuego, ¿qué prueba del Torneo de los Tres Magos realiza Harry en segundo lugar?\n",
                    respuestas = listOf(
                        Respuesta("Rescatar a un ser querido en el lago.", true),
                        Respuesta("Enfrentarse al dragón.", false),
                        Respuesta("Sobrevivir en el laberinto.", false),
                        Respuesta("Resolver un acertijo mágico en la Sala de los Secretos.", false)
                    )
                )
            )
        ),
        Categoria(
            nombre = "Poesia",
            imagen = "poeta",
            preguntas = listOf(
                Pregunta(
                    texto = "Es mejor ser temido que amado, si no puedes ser ambas cosas",
                    respuestas = listOf(
                        Respuesta("Es preferible que los gobernantes sean temidos, porque el miedo es un control más efectivo que el amor.", true),
                        Respuesta("Un líder debe inspirar terror en su pueblo para que no se rebelen.", false),
                        Respuesta("Es imposible que un gobernante sea amado por su pueblo, por lo que debe ser cruel.", false),
                        Respuesta("El amor es inútil en la política, solo la violencia garantiza el poder.", false)
                    )
                ),
                Pregunta(
                    texto = "El fin justifica los medios",
                    respuestas = listOf(
                        Respuesta("Un gobernante debe enfocarse en el objetivo final, sin importar los métodos utilizados para lograrlo.", true),
                        Respuesta("Cualquier acción, sin importar lo cruel que sea, es válida si se obtiene el resultado deseado.\n", false),
                        Respuesta("La moral es irrelevante en la política y solo importa el resultado.", false),
                        Respuesta("Los líderes deben evitar cuestionarse sus acciones si quieren tener éxito.", false)
                    )
                ),
                Pregunta(
                    texto = "Un príncipe nunca carece de razones legítimas para romper su promesa",
                    respuestas = listOf(
                        Respuesta("La astucia y la conveniencia son más importantes que la lealtad en la política. ", true),
                        Respuesta("Un gobernante no debe hacer promesas porque siempre terminará rompiéndolas.", false),
                        Respuesta("Es mejor ser honesto, pero un gobernante debe mentir cuando sea necesario.", false),
                        Respuesta("Solo los reyes pueden decidir qué promesas cumplir y cuáles ignorar", false)
                    )
                ),
                Pregunta(
                    texto = "La guerra es justa cuando es necesaria",
                    respuestas = listOf(
                        Respuesta("Los conflictos bélicos solo deben iniciarse si son inevitables para la supervivencia de un Estado.", true),
                        Respuesta(" La guerra solo es válida cuando se lucha por una causa noble.", false),
                        Respuesta("Todos los gobernantes deben estar en guerra constantemente para demostrar su poder.", false),
                        Respuesta("No hay reglas en la guerra, cualquier acto es legítimo si conduce a la victoria", false)
                    )
                ),
                Pregunta(
                    texto = "Los hombres olvidan más fácilmente la muerte de su padre que la pérdida de su patrimonio",
                    respuestas = listOf(
                        Respuesta("La gente valora más el dinero que las relaciones familiares.", true),
                        Respuesta("Los gobernantes deben enfocarse en proteger las riquezas de su pueblo", false),
                        Respuesta("El dolor de la pérdida económica es más intenso, pero no significa que la familia no sea importante.", false),
                        Respuesta("La herencia es lo único que define la identidad de una persona.", false)
                    )
                )
            )
        ),
        Categoria(
            nombre = "Aviones",
            imagen = "historia4",
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
            imagen = "geografia",
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
