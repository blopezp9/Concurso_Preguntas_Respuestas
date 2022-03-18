package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;

import java.util.List;

public interface ServicioJugador {

    Jugador CrearJugador(Jugador jugador);
    Jugador BuscarJugador(Long id);
    Jugador ModificarJugador(Long id, Jugador jugador);
}
