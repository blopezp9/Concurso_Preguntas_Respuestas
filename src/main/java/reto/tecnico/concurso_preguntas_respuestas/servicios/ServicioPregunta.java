package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;

import java.util.List;

public interface ServicioPregunta {

    public Pregunta CrearPregunta(Categoria categoria);
    public Pregunta ActualizarPregunta(Long id);
    public List<Pregunta> LstarPreguntas();

}
