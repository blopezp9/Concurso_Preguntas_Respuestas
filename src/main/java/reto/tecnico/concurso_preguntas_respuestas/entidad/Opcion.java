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
public class Opcion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Identificador_Opcion;
    private String opcion;
    private String respuesta;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Identificador_Pregunta")
    private Pregunta pregunta;

}
