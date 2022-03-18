package reto.tecnico.concurso_preguntas_respuestas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;

public interface RepositorioJugador extends JpaRepository<Jugador, Long> {

}
