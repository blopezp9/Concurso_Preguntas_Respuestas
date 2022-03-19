package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;

public interface ServicioJuego {

    Juego CrearJuego(Jugador jugador);
    Juego ConsultarHistorial(Long id);
    Juego ActualizarJuego(Juego juego);
}
