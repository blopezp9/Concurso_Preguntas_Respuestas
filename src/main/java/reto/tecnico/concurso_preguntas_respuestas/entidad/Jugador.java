package reto.tecnico.concurso_preguntas_respuestas.entidad;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Jugador {
    @Id
    private Long Identificador_jugador;
    private String Nombre;
    private String Apellido;
}