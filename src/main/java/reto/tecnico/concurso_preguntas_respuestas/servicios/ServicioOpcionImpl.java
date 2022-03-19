package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Opcion;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Repositorio_Opcion;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ServicioOpcionImpl implements ServicioOpcion{

    private final Repositorio_Opcion repositorio_opcion;

    @Override
    public Opcion CrearOpciones(Pregunta pregunta, int j, int i) {

        int n = 0;
        Opcion opcion = new Opcion();
        System.out.println("Opciones para la pregunta " + j + " de la categoría " + i);
        while (n<4){
           PreguntaPorOPcion(pregunta);
            n++;
        }
        ValidacionOpcion();

        return opcion;
    }

    @Override
    public Opcion ActualizarOpcion(Long id, String opciones) {
        Opcion opcion = new Opcion();
        int n = 0;

        if (BuscarOpcion(id) == null){
            System.out.println("Esta opcion no existe");
            return null;
        }else{
            opcion=BuscarOpcion(id);
            opcion.setOpcion(opciones);
        }
        return repositorio_opcion.save(opcion);
    }

    @Override
    public List<Opcion> LstarPciones() {
        return repositorio_opcion.findAll();
    }

    @Override
    public Opcion BuscarOpcion(Long id) {
        return repositorio_opcion.findById(id).orElse(null);
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

    public String OpcionValidacion(){
        String opcion = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        do {
            System.out.println ("Por favor introduzca la opcion:");
            opcion = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
            if (Objects.equals(opcion, "")){
                System.out.println("No deje el campo de opción vacío");
            }
        }while (opcion == "");

        return opcion;
    }

    public Opcion PreguntaPorOPcion(Pregunta pregunta){

        Opcion opcion = new Opcion();
        opcion.setOpcion(OpcionValidacion());
        opcion.setRespuesta("INCORRECTA");
        opcion.setPregunta(pregunta);

        return repositorio_opcion.save(opcion);
    }

    public void ValidacionOpcion(){

        String pregunta_ = "";
        String Pregunta2 = "";
        String Pregunta3 = "";
        Long e = 0L;
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        do {
            for (int i=0;i< LstarPciones().size();i++) {
                System.out.println("Opcion: "+LstarPciones().get(i).getIdentificador_Opcion() +" "+ LstarPciones().get(i).getOpcion() + " Pregunta: " + LstarPciones().get(i).getPregunta().getPregunta());
            }
            System.out.println("¿Quiere corregir alguna opción?. Ingrese 1 para corregir o ingrese 2 para seguir con la siguiente pregunta");
            pregunta_ = entradaEscaner.nextLine ();
            if (!String_int(pregunta_) || Objects.equals(pregunta_, "")){
                System.out.printf("Por favor seleccione alguna de las opciones, no ingrese letras o espacios en blanco");
            }else
            if (String_int2(pregunta_) > 2 || String_int2(pregunta_) < 1){
                System.out.println("Por favor seleccione unicamente 1 o 2");
            }else{
                if(String_int2(pregunta_) == 1){
                    System.out.println("Ingrese el número de la opción a corregir");
                    Pregunta2 = entradaEscaner.nextLine ();
                    e = (long) String_int2(Pregunta2);
                    Pregunta3=OpcionValidacion();
                    ActualizarOpcion(e, Pregunta3);
                    pregunta_="1";
                }

            }

        }while (!String_int(pregunta_) || Objects.equals(pregunta_, "") || (String_int2(pregunta_) > 2 || String_int2(pregunta_) < 1) || (String_int2(pregunta_) == 1));
    }

}
