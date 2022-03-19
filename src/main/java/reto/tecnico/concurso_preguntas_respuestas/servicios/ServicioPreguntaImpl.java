package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Repositorio_Pregunta;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioPreguntaImpl implements ServicioPregunta {

    private final Repositorio_Pregunta repositorio_pregunta;

    @Override
    public Pregunta CrearPregunta(Categoria categoria) {

        Pregunta pregunta = new Pregunta();


        return repositorio_pregunta.save(pregunta);
    }

    @Override
    public Pregunta ActualizarPregunta(Long id) {

        return null;
    }

    @Override
    public List<Pregunta> LstarPreguntas() {
        return null;
    }
}
