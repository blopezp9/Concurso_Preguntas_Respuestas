package reto.tecnico.concurso_preguntas_respuestas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Respuesta;

public interface Repositorio_Respuesta extends JpaRepository<Respuesta, Long> {
}
