package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;

public interface ServicioJuego {

    Juego CrearJuego(Juego juego);
    Juego ConsultarHistorial(Long id);
    Juego ActualizarJuego(Long id);
}
