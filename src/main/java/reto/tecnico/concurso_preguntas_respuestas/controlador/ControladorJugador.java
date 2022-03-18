package reto.tecnico.concurso_preguntas_respuestas.controlador;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioJugador;

import java.util.Scanner;

@RestController
@RequestMapping("/jugador")
@RequiredArgsConstructor
public class ControladorJugador {

    private final ServicioJugador servicioJugador;

    @GetMapping
    public ResponseEntity CrearJugador(Jugador jugador){
        //jugador.setNombre("Bryan");
        //jugador.setApellido("Lopez");

        System.out.println ("Por favor introduzca el nombre:");
        String entradaTeclado = "";

        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        jugador.setNombre(entradaTeclado);
        jugador.setApellido(entradaTeclado);
        System.out.println(jugador.getApellido());
        return new ResponseEntity(servicioJugador.CrearJugador(jugador), HttpStatus.CREATED);

    }
}
