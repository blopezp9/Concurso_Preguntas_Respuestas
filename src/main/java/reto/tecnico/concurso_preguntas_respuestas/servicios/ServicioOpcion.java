package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Opcion;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;

import java.util.List;

public interface ServicioOpcion {

    public Opcion CrearOpciones(Pregunta pregunta, int j, int i);
    public Opcion ActualizarOpcion(Long id, String pregunta);
    public List<Opcion> LstarPciones();
    public Opcion BuscarOpcion(Long id);
}
