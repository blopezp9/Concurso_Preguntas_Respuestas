package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;

import java.util.List;

public interface ServicioCategoria {

    Categoria CrearCategoria(Juego juego);
    List<Categoria> ListCategoria();
}
