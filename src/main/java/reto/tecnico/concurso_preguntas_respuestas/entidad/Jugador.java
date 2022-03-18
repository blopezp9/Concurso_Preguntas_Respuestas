package reto.tecnico.concurso_preguntas_respuestas.entidad;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Identificador_jugador;
    private String Nombre;
    private String Apellido;


}