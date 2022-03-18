package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.RepositorioJugador;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioJugadorImpl implements ServicioJugador {


    private final RepositorioJugador repositorioJugador;

    @Override
    public Jugador CrearJugador(Jugador jugador) {

        //Hay que validar si el usuario ya existe o no
        return repositorioJugador.save(jugador);
    }

    @Override
    public Jugador BuscarJugador(Long id) {

        //Se debe validar que no ingrese letras
        return repositorioJugador.findById(id).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public Jugador ModificarJugador(Long id, Jugador jugador) {

        //Validar si existe el jugar?
        Jugador jugadorBuscado=repositorioJugador.findById(id).get();
        jugadorBuscado.setNombre(jugador.getNombre());
        jugadorBuscado.setApellido(jugador.getApellido());
        return repositorioJugador.save(jugadorBuscado);

    }
}
