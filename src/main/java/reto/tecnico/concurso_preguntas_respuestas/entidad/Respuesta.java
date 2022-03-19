package reto.tecnico.concurso_preguntas_respuestas.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Respuesta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Identificador_Respuesta;
    private String Respuesta;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Identificador_Pregunta")
    private Pregunta pregunta;
}
