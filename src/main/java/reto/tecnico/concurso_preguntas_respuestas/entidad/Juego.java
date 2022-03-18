package reto.tecnico.concurso_preguntas_respuestas.entidad;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Juego {

    @Id
    private Long Identificador_Juego;
    private String Nombre_Juego;
    private Integer Puntaje_Jugador;
    private Integer Ronda;
    private String Estado;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Juego;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Identificador_jugador")
    private Jugador jugador;
}
