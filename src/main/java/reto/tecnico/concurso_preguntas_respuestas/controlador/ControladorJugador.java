package reto.tecnico.concurso_preguntas_respuestas.controlador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioJugador;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jugador")
@RequiredArgsConstructor
public class ControladorJugador {

    private final ServicioJugador servicioJugador;

    @PostMapping
    @ResponseBody
    @Valid
    public ResponseEntity CrearJugador (Jugador jugador, BindingResult result){

            jugador = new Jugador();
            servicioJugador.CrearJugador(jugador);
            return ResponseEntity.ok("Jugador creado con éxito");

    }


}
