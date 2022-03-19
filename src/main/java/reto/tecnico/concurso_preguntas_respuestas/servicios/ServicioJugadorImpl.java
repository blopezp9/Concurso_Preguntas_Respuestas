package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.RepositorioJugador;

import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ServicioJugadorImpl implements ServicioJugador {


    private final RepositorioJugador repositorioJugador;


    @Override
    public Jugador CrearJugador(Jugador jugador) {
        String id = "";
        String nombre = "";
        String apellido = "";
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
        jugador.setIdentificador_jugador(String_Longs(id));

        System.out.println ("Por favor introduzca el nombre:");
        nombre = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        jugador.setNombre(nombre);

        System.out.println ("Por favor introduzca sus apellidos:");
        apellido = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        jugador.setApellido(apellido);

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
}
