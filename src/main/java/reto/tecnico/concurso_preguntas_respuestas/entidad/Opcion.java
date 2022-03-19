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
    private Long Identificador_Pregunta;
    private String opcion;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Identificador_Categoria")
    private Pregunta pregunta;

}
