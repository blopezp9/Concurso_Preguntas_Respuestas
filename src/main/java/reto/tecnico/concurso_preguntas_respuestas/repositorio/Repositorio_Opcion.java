package reto.tecnico.concurso_preguntas_respuestas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Opcion;

public interface Repositorio_Opcion extends JpaRepository<Opcion, Long> {
}
