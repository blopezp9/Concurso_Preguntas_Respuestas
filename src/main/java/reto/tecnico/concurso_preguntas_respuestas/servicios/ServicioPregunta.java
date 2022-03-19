package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;

import java.util.List;

public interface ServicioPregunta {

    public Pregunta CrearPregunta(Categoria categoria, int j);
    public Pregunta ActualizarPregunta(Long id, String pregunta);
    public List<Pregunta> LstarPreguntas();
    public Pregunta BuscarPregunta(Long id);

}
