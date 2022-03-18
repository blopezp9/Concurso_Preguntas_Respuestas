package reto.tecnico.concurso_preguntas_respuestas.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Jugador;

import java.util.List;

public interface interfaceJuego extends JpaRepository<Jugador, Long> {

    public List<Juego> findByIdentificador_jugador(Jugador jugador);
}
