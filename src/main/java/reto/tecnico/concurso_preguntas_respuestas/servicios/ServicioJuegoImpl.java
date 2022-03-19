package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Reposiotrio_Categoria;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Repositorio_Juego;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
@AllArgsConstructor
public class ServicioJuegoImpl implements ServicioJuego{

    private final Repositorio_Juego repositorio_juego;
    private final ServicioCategoria servicioCategoria;

    @Override
    public Juego CrearJuego(Jugador jugador) {
        Juego juego = new Juego();
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        juego.setNombre_Juego("Juego 1");
        juego.setPuntaje_Jugador(0);
        juego.setRonda(1);
        juego.setEstado("Sin terminar");
        juego.setFecha_Juego(timeStamp);
        juego.setJugador(jugador);
        servicioCategoria.CrearCategoria(juego);
        return repositorio_juego.save(juego);
    }

    @Override
    public Juego ConsultarHistorial(Long id) {
        return repositorio_juego.findById(id).orElse(null);
    }

    @Override
    public Juego ActualizarJuego(Juego juegos) {
        Juego juego = new Juego();

        juego.setNombre_Juego(juegos.getNombre_Juego());
        juego.setPuntaje_Jugador(juegos.getPuntaje_Jugador());
        juego.setRonda(juegos.getRonda());
        juego.setEstado(juegos.getEstado());
        return repositorio_juego.save(juego);
    }
}
