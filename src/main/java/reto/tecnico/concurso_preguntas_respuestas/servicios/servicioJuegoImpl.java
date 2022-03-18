package reto.tecnico.concurso_preguntas_respuestas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.interfaces.interfaceJuego;

import java.util.Date;
import java.util.List;

public class servicioJuegoImpl implements servicioJuego{

    @Autowired
    private interfaceJuego interfaceJuego;

    @Override
    public List<Jugador> listJuegos() {
        return interfaceJuego.findAll();
    }

    @Override
    public Juego getJuego(Long id) {
        return null;
    }

    @Override
    public Juego crearJuego(String nombre_juego, Date Fecha_Juego) {
        return null;
    }

    @Override
    public Juego actualizarJuego(Long id, Integer puntaje, Integer ronda, String estado) {
        return null;
    }
}
