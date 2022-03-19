package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.RepositorioJugador;

import java.util.Objects;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ServicioJugadorImpl implements ServicioJugador {


    private final RepositorioJugador repositorioJugador;
    private final ServicioJuego servicioJuego;


    @Override
    public Jugador CrearJugador(Jugador jugador) {

        jugador.setIdentificador_jugador(IdValidacion());
        jugador.setNombre(NombreValidacion());
        jugador.setApellido(ApelldioValidacion());
        servicioJuego.CrearJuego(jugador);
        return repositorioJugador.save(jugador);
    }

    @Override
    public Jugador BuscarJugador(Long id) {

        //Se debe validar que no ingrese letras
        return repositorioJugador.findById(id).orElse(null);
    }

    @Override
    public Jugador ModificarJugador(Long id, Jugador jugador) {

        //Validar si existe el jugar?
        Jugador jugadorBuscado=repositorioJugador.findById(id).get();
        jugadorBuscado.setNombre(jugador.getNombre());
        jugadorBuscado.setApellido(jugador.getApellido());
        return repositorioJugador.save(jugadorBuscado);

    }

    public Long String_Longs (String id) {
            long myLong;
        try{
            myLong = Long.parseLong(id);
            return(myLong);

        }
        catch (Exception e) {
           return -0L;
        }

    }

    public boolean String_int(String nombre){
        int myint;
        try{
            myint = Integer.parseInt(nombre);
            return true;

        }
        catch (Exception e) {
            return false;
        }
    }

    public Long IdValidacion(){
        String id ="";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        do {
            System.out.println ("Por favor introduzca su identificación:");
            id = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
            if (String_Longs(id) == -0L){
                System.out.println("No ingrese letras, solo números");
            }else {
                if (BuscarJugador(String_Longs(id)) != null) {
                    System.out.println("Este usuario ya existe");
                }
            }

        }while (String_Longs(id) == -0L || BuscarJugador(String_Longs(id)) != null );

        return String_Longs(id);
    }

    public String NombreValidacion(){
        String nombre = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        do {
            System.out.println ("Por favor introduzca el nombre:");
            nombre = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
            if (Objects.equals(nombre, "")){
                System.out.println("No deje el campo nombre vacío");
            }else
                if (String_int(nombre)){
                    System.out.println("No ingrese números en el campo nombre");
                }
        }while (nombre == "" || String_int(nombre));

        return nombre;
    }

    public String ApelldioValidacion(){
        String apellido = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        do {
            System.out.println ("Por favor introduzca el apellido:");
            apellido = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
            if (Objects.equals(apellido, "")){
                System.out.println("No deje el campo nombre vacío");
            }else
            if (String_int(apellido)){
                System.out.println("No ingrese números en el campo apellido");
            }
        }while (apellido == "" || String_int(apellido));

        return apellido;
    }

}
