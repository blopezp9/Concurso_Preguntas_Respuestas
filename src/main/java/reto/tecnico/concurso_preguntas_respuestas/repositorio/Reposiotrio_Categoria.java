package reto.tecnico.concurso_preguntas_respuestas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;

public interface Reposiotrio_Categoria extends JpaRepository<Categoria, Long> {
}
