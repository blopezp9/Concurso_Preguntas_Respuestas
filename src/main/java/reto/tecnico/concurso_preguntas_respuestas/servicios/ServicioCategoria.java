package reto.tecnico.concurso_preguntas_respuestas.servicios;

import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;

import java.util.List;

public interface ServicioCategoria {

    public Categoria CrearCategoria(Juego juego);
    public List<Categoria> ListCategoria();
    public Categoria CategoriaExistente(Juego juego);
}
