package reto.tecnico.concurso_preguntas_respuestas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Pregunta;

public interface Repositorio_Opcion extends JpaRepository<Pregunta, Long> {
}
