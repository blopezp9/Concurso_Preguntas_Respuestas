package reto.tecnico.concurso_preguntas_respuestas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;

public interface Repositorio_Juego extends JpaRepository<Juego, Long> {
}
