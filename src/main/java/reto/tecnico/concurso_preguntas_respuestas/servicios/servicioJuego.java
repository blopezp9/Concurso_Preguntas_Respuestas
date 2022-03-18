package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;

import java.util.Date;
import java.util.List;

public interface servicioJuego {

    public List<Jugador> listJuegos();
    public Juego getJuego(Long id);
    public Juego crearJuego(String nombre_juego, Date Fecha_Juego);
    public Juego actualizarJuego(Long id, Integer puntaje, Integer ronda, String estado);

}
