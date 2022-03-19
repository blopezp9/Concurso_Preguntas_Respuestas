package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Opcion;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Repositorio_Opcion;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioOpcionImpl implements ServicioOpcion{

    private final Repositorio_Opcion repositorio_opcion;

    @Override
    public Opcion CrearOpciones(Pregunta pregunta) {
        return null;
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
        return null;
    }

    @Override
    public Pregunta BuscarOpcion(Long id) {
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


}
