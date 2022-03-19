package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Reposiotrio_Categoria;

@Service
@AllArgsConstructor
public class ServicioCategoriaImpl implements ServicioCategoria{

    private final Reposiotrio_Categoria reposiotrio_categoria;

    @Override
    public Categoria CrearCategoria(Juego juego) {
        int n = 0;
        Categoria categoria = new Categoria();

        while (n<5){
            categoria.setNombre_Categoria("Categoria" + (n+1));
            categoria.setJuego(juego);
            n++;
        }


        return reposiotrio_categoria.save(categoria);
    }
}
