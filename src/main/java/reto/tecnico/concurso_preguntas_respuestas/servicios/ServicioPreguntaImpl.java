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

    @Override
    public Pregunta CrearPregunta(Categoria categoria, int j) {
        int n=0;
        Pregunta pregunta = new Pregunta();
        System.out.println("Preguntas para la categoría " + j);
        while (n<5){
            PreguntaPorCategoria(categoria);
            n++;
        }
        return pregunta;
    }

    @Override
    public Pregunta ActualizarPregunta(Long id, String preguntas) {

        Pregunta pregunta = new Pregunta();
        int n = 0;

        if (BuscarPregunta(id) == null){
            System.out.println("Esta pregunta no existe");
        }else{
               pregunta.setPregunta(PreguntaValidacion());
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

    public Pregunta PreguntaPorCategoria(Categoria categoria){

            Pregunta pregunta = new Pregunta();
            pregunta.setPregunta(PreguntaValidacion());
            pregunta.setCategoria(categoria);

            return repositorio_pregunta.save(pregunta);
    }


}
