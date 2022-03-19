package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Repositorio_Juego;

@Service
@AllArgsConstructor
public class ServicioJuegoImpl implements ServicioJuego{

    private final Repositorio_Juego repositorio_juego;

    @Override
    public Juego CrearJuego(Juego juego) {
        return repositorio_juego.save(juego);
    }

    @Override
    public Juego ConsultarHistorial(Long id) {
        return repositorio_juego.findById(id).orElse(null);
    }

    @Override
    public Juego ActualizarJuego(Long id) {

        return null;
    }
}
