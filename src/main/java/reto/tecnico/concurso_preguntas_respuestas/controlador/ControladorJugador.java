package reto.tecnico.concurso_preguntas_respuestas.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioJuego;
import reto.tecnico.concurso_preguntas_respuestas.servicios.ServicioJugador;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Scanner;


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
            //servicioJugador.CrearJugador(jugador);
            Opciones();

            return ResponseEntity.ok("Jugador creado con éxito");

    }
    public boolean String_int(String pregunta){
        int myint;
        try{
            myint = Integer.parseInt(pregunta);
            return true;

        }
        catch (Exception e) {
            return false;
        }
    }

    public int String_int2(String pregunta){
        int myint;
        try{
            myint = Integer.parseInt(pregunta);
            return myint;

        }
        catch (Exception e) {
            return -1;
        }
    }

    public void Opciones (){

        String pregunta1 = "";
        String Pregunta2 = "";
        String Pregunta3 = "";
        Jugador jugador = new Jugador();

        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        do {

            System.out.println("Ingrese 1 para crear jugador y crear juego. Ingrese 2 para crear juego si ya tiene un usuario registrado. Ingrese 3 para jugar");
            pregunta1 = entradaEscaner.nextLine ();
            if (!String_int(pregunta1) || Objects.equals(pregunta1, "")){
                System.out.printf("Por favor seleccione alguna de las opciones, no ingrese letras o espacios en blanco");
            }else
            if (String_int2(pregunta1) > 3 || String_int2(pregunta1) < 1){
                System.out.println("Por favor seleccione unicamente 1, 2 o 3");
            }else{
                if(String_int2(pregunta1) == 1){
                    servicioJugador.CrearJugador(jugador);
                }else{
                    if (String_int2(pregunta1) == 2){
                        Opcion2();
                    }
                }

            }

        }while (!String_int(pregunta1) || Objects.equals(pregunta1, "") || (String_int2(pregunta1) > 3 || String_int2(pregunta1) < 1));

    }

    public void Opcion2() {

        String pregunta1 = "";
        Jugador jugador = new Jugador();

        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        do {
            System.out.println("Ingrese su Identificación con el cual se registró");
            pregunta1 = entradaEscaner.nextLine ();
            if (!String_int(pregunta1) || Objects.equals(pregunta1, "")) {
                System.out.printf("Por favor no ingrese letras ni deje el campo vacío");
            }else {
                jugador=servicioJugador.BuscarJugador((long) String_int2(pregunta1));
                if (jugador!=null){
                    System.out.println("Bienvenido: " + jugador.getNombre());
                    servicioJuego.CrearJuego(jugador);
                }else{
                    System.out.println("Este usuario no existe");
                    Opciones();
                }
            }
        }while(!String_int(pregunta1) || Objects.equals(pregunta1, ""));

    }

    public void Opcion3 (){
        String pregunta1 = "";
        Jugador jugador = new Jugador();

        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        do {
            System.out.println("Ingrese su Identificación con el cual se registró");
            pregunta1 = entradaEscaner.nextLine ();
            if (!String_int(pregunta1) || Objects.equals(pregunta1, "")) {
                System.out.printf("Por favor no ingrese letras ni deje el campo vacío");
            }else {
                jugador=servicioJugador.BuscarJugador((long) String_int2(pregunta1));
                if (jugador!=null){
                    System.out.println("Bienvenido: " + jugador.getNombre());
                    servicioJuego.CrearJuego(jugador);
                }else{
                    System.out.println("Este usuario no existe");
                    Opciones();
                }
            }
        }while(!String_int(pregunta1) || Objects.equals(pregunta1, ""));
    }



}
