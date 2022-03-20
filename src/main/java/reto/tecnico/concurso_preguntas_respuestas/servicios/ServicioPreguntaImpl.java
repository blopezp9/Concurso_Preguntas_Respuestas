package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Repositorio_Pregunta;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ServicioPreguntaImpl implements ServicioPregunta {

    private final Repositorio_Pregunta repositorio_pregunta;
    private final ServicioOpcion servicioOpcion;

    @Override
    public Pregunta CrearPregunta(Categoria categoria, int j) {
        int n=0;

        Pregunta pregunta = new Pregunta();
        System.out.println("Preguntas para la categoría " + j);
        while (n<5){
            PreguntaPorCategoria(categoria, n, j);
            n++;
        }

         ValidacionPregunta();

        return pregunta;
    }

    @Override
    public Pregunta ActualizarPregunta(Long id, String preguntas) {

        Pregunta pregunta = new Pregunta();
        int n = 0;

        if (BuscarPregunta(id) == null){
            System.out.println("Esta pregunta no existe");
            return null;
        }else{
               pregunta=BuscarPregunta(id);
               pregunta.setPregunta(preguntas);
        }
        return repositorio_pregunta.save(pregunta);
    }

    @Override
    public List<Pregunta> LstarPreguntas() {
        return repositorio_pregunta.findAll();
    }

    @Override
    public Pregunta BuscarPregunta(Long id) {
        return repositorio_pregunta.findById(id).orElse(null);
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

    public String PreguntaValidacion(){
        String pregunta = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        do {
            System.out.println ("Por favor introduzca la pregunta:");
            pregunta = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
            if (Objects.equals(pregunta, "")){
                System.out.println("No deje el campo de pregunta vacío");
            }else
            if (String_int(pregunta)){
                System.out.println("No ingrese números en el campo pregunta");
            }
        }while (pregunta == "" || String_int(pregunta));

        return pregunta;
    }

    public Pregunta PreguntaPorCategoria(Categoria categoria, int n, int j){

            Pregunta pregunta = new Pregunta();
            pregunta.setPregunta(PreguntaValidacion());
            pregunta.setCategoria(categoria);
            servicioOpcion.CrearOpciones(pregunta, (n+1), j);

            return repositorio_pregunta.save(pregunta);
    }

    public void ValidacionPregunta(){

        String pregunta_ = "";
        String Pregunta2 = "";
        String Pregunta3 = "";
        Long e = 0L;
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        do {
            for (int i=0;i<LstarPreguntas().size();i++) {
                System.out.println("Pregunta "+LstarPreguntas().get(i).getIdentificador_Pregunta() +" "+ LstarPreguntas().get(i).getPregunta() + " " + LstarPreguntas().get(i).getCategoria().getNombre_Categoria());
            }
            System.out.println("¿Quiere corregir alguna pregunta?. Ingrese 1 para corregir o ingrese 2 para proseguir");
            pregunta_ = entradaEscaner.nextLine ();
            if (!String_int(pregunta_) || Objects.equals(pregunta_, "")){
                System.out.printf("Por favor seleccione alguna de las opciones, no ingrese letras o espacios en blanco");
            }else
                if (String_int2(pregunta_) > 2 || String_int2(pregunta_) < 1){
                    System.out.println("Por favor seleccione unicamente 1 o 2");
                }else{
                    if(String_int2(pregunta_) == 1){
                        System.out.println("Ingrese el número de la pregunta a corregir");
                        Pregunta2 = entradaEscaner.nextLine ();
                        e = (long) String_int2(Pregunta2);
                        Pregunta3=PreguntaValidacion();
                        ActualizarPregunta(e, Pregunta3);
                            pregunta_="1";
                    }

                }

        }while (!String_int(pregunta_) || Objects.equals(pregunta_, "") || (String_int2(pregunta_) > 2 || String_int2(pregunta_) < 1) || (String_int2(pregunta_) == 1));
    }

    @Override
    public int Aleatorio (){
        int min = 1;
        int max = 5;
        int getRandomValue = 0;
        for(int i = min; i <=max; i++) {
            getRandomValue = (int) (Math.random()*(max-min)) + min;
        }
        return getRandomValue;
    }

}
