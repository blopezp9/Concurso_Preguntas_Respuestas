package reto.tecnico.concurso_preguntas_respuestas.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioJuego;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioJugador;

import javax.validation.Valid;


@RestController
@RequestMapping("/jugador")
@RequiredArgsConstructor
public class ControladorJugador {

    private final ServicioJugador servicioJugador;
    private final ServicioJuego servicioJuego;

    @PostMapping
    @ResponseBody
    @Valid
    public ResponseEntity CrearJugador (Jugador jugador, BindingResult result){

            jugador = new Jugador();
            servicioJugador.CrearJugador(jugador);
            return ResponseEntity.ok("Jugador creado con éxito");

    }


}
