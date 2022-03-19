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
public class Categoria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Identiicador_Jeugo;
    private String Nombre_Categoria;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Identificador_Juego")
    private Juego juego;

}
