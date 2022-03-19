package reto.tecnico.concurso_preguntas_respuestas.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Juego {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Identificador_Juego;
    private String Nombre_Juego;
    private Integer Puntaje_Jugador;
    private Integer Ronda;
    private String Estado;
    private String Fecha_Juego;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Identificador_Jugador")
    private Jugador jugador;
}
