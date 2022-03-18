package reto.tecnico.concurso_preguntas_respuestas.servicios;

import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;

import java.util.List;

@Service
public class ServicioJugadorImpl implements ServicioJugador {

    @Override
    public Jugador CrearUsuario(Jugador jugador) {
        return null;
    }

    @Override
    public List<Jugador> BuscarJugador(Long id) {
        return null;
    }

    @Override
    public Jugador ModificarJugador(Long id, Jugador jugador) {
        return null;
    }
}
