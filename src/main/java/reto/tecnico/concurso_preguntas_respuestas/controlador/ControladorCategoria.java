package reto.tecnico.concurso_preguntas_respuestas.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioCategoria;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class ControladorCategoria {

    private final ServicioCategoria servicioCategoria;

    @PostMapping
    @ResponseBody
    public ResponseEntity CrearCategoria(Juego juego){

        servicioCategoria.CrearCategoria(juego);

        return ResponseEntity.ok("Ctegorias creadas con éxito");
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Juego>> ListaJuego(){

        List<Juego> juegos = new ArrayList<>();
        return ResponseEntity.ok(juegos);
    }

}
