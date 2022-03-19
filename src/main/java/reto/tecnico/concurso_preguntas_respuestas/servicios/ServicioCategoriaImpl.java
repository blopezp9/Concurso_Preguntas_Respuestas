package reto.tecnico.concurso_preguntas_respuestas.servicios;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Categoria;
import reto.tecnico.concurso_preguntas_respuestas.entidad.Juego;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Reposiotrio_Categoria;
import reto.tecnico.concurso_preguntas_respuestas.repositorio.Repositorio_Juego;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioCategoriaImpl implements ServicioCategoria{

    private final Reposiotrio_Categoria reposiotrio_categoria;
    private final Repositorio_Juego repositorio_juego;

    @Override
    public Categoria CrearCategoria(Juego juego) {
        int n = 0;
        Categoria categoria = new Categoria();

        while (n<5){
            categoria.setNombre_Categoria("Categoria" + (n+1));
            categoria.setJuego(juego);
            reposiotrio_categoria.save(categoria);
            n++;
        }


        return reposiotrio_categoria.save(categoria);
    }

    @Override
    public List<Categoria> ListCategoria() {
        return null;
    }
}
