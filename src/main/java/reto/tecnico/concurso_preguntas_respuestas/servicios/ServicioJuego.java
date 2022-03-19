package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;

public interface ServicioJuego {

    public Juego CrearJuego(Jugador jugador);
    public Juego ConsultarHistorial(Long id);
    public Juego ActualizarJuego(Juego juego);
}
