package reto.tecnico.concurso_preguntas_respuestas.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioCategoria;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioJuego;

@RestController
@RequestMapping("/juego")
@RequiredArgsConstructor
public class ControladorJuego {

    private final ServicioJuego servicioJuego;
    private final ServicioCategoria servicioCategoria;

    @PostMapping
    @ResponseBody
    public ResponseEntity CrearJuego(Jugador jugador){

        jugador = new Jugador();

        servicioCategoria.CrearCategoria(servicioJuego.CrearJuego(jugador));
        return ResponseEntity.ok("Juego creado con éxito");

    }
}
