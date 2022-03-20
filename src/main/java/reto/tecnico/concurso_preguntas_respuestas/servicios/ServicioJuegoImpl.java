package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Opcion;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Reposiotrio_Categoria;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Repositorio_Juego;

import javax.crypto.spec.PSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ServicioJuegoImpl implements ServicioJuego{

    private final Repositorio_Juego repositorio_juego;
    private final ServicioCategoria servicioCategoria;
    private final ServicioPregunta servicioPregunta;
    private final ServicioOpcion servicioOpcion;

    @Override
    public Juego CrearJuego(Jugador jugador) {
        String nombre = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        do {
            System.out.println ("Por favor introduzca el nombre del juego:");
            nombre = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
            if (Objects.equals(nombre, "")){
                System.out.println("Por favor no deje el campo vacío");
            }
        }while(Objects.equals(nombre, ""));
        repositorio_juego.deleteAll();
        Juego juego = new Juego();
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        juego.setNombre_Juego(nombre);
        juego.setPuntaje_Jugador(0);
        juego.setRonda(0);
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

        juego.setIdentificador_Juego(juegos.getIdentificador_Juego());
        juego.setNombre_Juego(juegos.getNombre_Juego());
        juego.setJugador(juegos.getJugador());
        juego.setFecha_Juego(juegos.getFecha_Juego());
        juego.setPuntaje_Jugador(juegos.getPuntaje_Jugador());
        juego.setRonda(juegos.getRonda());
        juego.setEstado(juegos.getEstado());
        return repositorio_juego.save(juego);
    }

    @Override
    public void EmpezarJuego(Jugador jugador){
        int j = 0;
        Juego juego = new Juego();
        juego=BuscarJuego(jugador);
        if  (juego==null){
            System.out.println("No tiene ningún juego asociado, será redirigido a un juego existente");
            JuegoExistente(jugador);

        }else{
            PreguntasJuego(juego, j, jugador);
        }


        System.out.println();

    }

    public Juego BuscarJuego(Jugador jugador){
        Juego juego = new Juego();
        juego=null;
        for (int i=0;i< ListarJuegos().size();i++) {
           if (Objects.equals(ListarJuegos().get(i).getJugador().getIdentificador_jugador(), jugador.getIdentificador_jugador())){
               juego=ListarJuegos().get(i);
               System.out.println("Este es su historial hasta el momento");
               System.out.println("Nombre del Juego: " + ListarJuegos().get(i).getNombre_Juego());
               System.out.println("Nombre del jugador: " + ListarJuegos().get(i).getJugador().getNombre());
               System.out.println("Rondas ganadas: " + ListarJuegos().get(i).getRonda());
               System.out.println("Fecha del juego: " + ListarJuegos().get(i).getFecha_Juego());
               System.out.println("Puntos obtenidos: " + ListarJuegos().get(i).getPuntaje_Jugador());
               System.out.println("Estado del juego: " + ListarJuegos().get(i).getEstado());
           }
        }

        return juego;
    }

    public void PreguntasJuego(Juego juego, int j, Jugador jugador){
        int n,y,s = 0;
        boolean b = false;
        Pregunta pregunta = new Pregunta();

        Long id=0L;
        for (int i=0;i< servicioCategoria.ListCategoria().size();i++) {
            y=0;
            n=servicioPregunta.Aleatorio();
            System.out.println("Pregunta para la ronda " + (i+1));
            for (int x=0;x< servicioPregunta.LstarPreguntas().size();x++){
                    if (Objects.equals(servicioPregunta.LstarPreguntas().get(x).getCategoria().getNombre_Categoria(), servicioCategoria.ListCategoria().get(i).getNombre_Categoria())){
                        pregunta=Generar5preguntas((i+1), (long) n);
                        //System.out.println(servicioPregunta.BuscarPregunta((long) n).getPregunta());
                        System.out.println("OPCIONES");
                        for (int z=0;z< servicioOpcion.LstarPciones().size();z++){
                            if (Objects.equals(servicioOpcion.LstarPciones().get(z).getPregunta().getPregunta(), pregunta.getPregunta())){
                                System.out.println("Opción: " + servicioOpcion.LstarPciones().get(z).getIdentificador_Opcion() + " " + servicioOpcion.LstarPciones().get(z).getOpcion());
                                y++;
                                if (y==4){
                                    x=servicioPregunta.LstarPreguntas().size();
                                    if (VerificarOpcion(juego, (long) Validaciones(),jugador) == 1){
                                        s=1;
                                        break;
                                    }
                                }
                            }

                        }

                    }
                    //VerificarOpcion(juego, (long) Validaciones(),jugador);
            }
            if (s==1){
                break;
            }

            if (i==6){

                i=servicioCategoria.ListCategoria().size();
                System.out.println("Felicitaciones, ganaste el juego");
            }

        }

    }

    public int Validaciones(){
        String opcion = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        do {
            System.out.println("Por favor ingrese la opción que considere sea la correcta");
            opcion=entradaEscaner.nextLine();

            if (!String_int(opcion) || Objects.equals(opcion, "")){
                System.out.println("No ingrese letras ni tampoco deje el campo vacío ");
            }
        }while (!String_int(opcion) || Objects.equals(opcion, ""));


        return String_int2(opcion);
    }

    public int VerificarOpcion(Juego juegos, Long idOpcion, Jugador jugador){
        int puntos=0;
        int l =0;


        if (Objects.equals(servicioOpcion.BuscarOpcion(idOpcion).getRespuesta(), "CORRECTA")){
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            puntos=puntos+10;
            juegos.setIdentificador_Juego(juegos.getIdentificador_Juego());
            juegos.setJugador(jugador);
            juegos.setPuntaje_Jugador(juegos.getPuntaje_Jugador()+puntos);
            juegos.setRonda(juegos.getRonda()+1);
            juegos.setFecha_Juego(timeStamp);
            juegos.setEstado("JUGADO");
            ActualizarJuego(juegos);
            BuscarJuego(jugador);

            System.out.println("Es correcto, obtiene 10 puntos");
            String opcion = "";
            Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

            do {
                System.out.println("Ingrese 1 para seguir jugando. Ingrese 2 para salir del juego");
                opcion=entradaEscaner.nextLine();

                if (!String_int(opcion) || Objects.equals(opcion, "")){
                    System.out.println("No ingrese letras ni tampoco deje el campo vacío ");
                }else{
                    if(String_int2(opcion)==2){
                        l++;
                    }
                }
            }while (!String_int(opcion) || Objects.equals(opcion, "") || (String_int2(opcion)>2 || (String_int2(opcion)<1)));


        }else {
            System.out.println("Perdiste, no se obtuvieron puntos, saliendo del juego");
            BuscarJuego(juegos.getJugador());
            l++;


        }
        return l;
    }

    @Override
    public List<Juego> ListarJuegos(){
        return repositorio_juego.findAll();
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

    public Pregunta Generar5preguntas(int q, Long id){
        int n=0;

        Pregunta pregunta = new Pregunta();

        for (int i=0;i< servicioPregunta.LstarPreguntas().size();i++) {
            if(Objects.equals(servicioPregunta.LstarPreguntas().get(i).getCategoria().getIdentificador_Categoria(), id)){
                n = n + Math.toIntExact(servicioPregunta.LstarPreguntas().get(i).getIdentificador_Pregunta()) + servicioPregunta.Aleatorio();
                i=servicioPregunta.LstarPreguntas().size();
                pregunta=servicioPregunta.BuscarPregunta((long) n);
                System.out.println(servicioPregunta.BuscarPregunta((long) n).getPregunta());
            }

        }
        return pregunta;

    }

    public Juego JuegoExistente(Jugador jugador){

        Juego juego = new Juego();
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        juego.setNombre_Juego("Por defecto");
        juego.setPuntaje_Jugador(0);
        juego.setRonda(0);
        juego.setEstado("Sin terminar");
        juego.setFecha_Juego(timeStamp);
        juego.setJugador(jugador);
        servicioCategoria.CategoriaExistente(juego);
        return repositorio_juego.save(juego);

    }

}
