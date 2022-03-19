package reto.tecnico.concurso_preguntas_respuestas.entidad;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.hibernate.internal.CoreLogging;
import org.springframework.lang.NonNull;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Jugador {
    @Id
    private Long Identificador_jugador;
    private String Nombre;
    private String Apellido;


}