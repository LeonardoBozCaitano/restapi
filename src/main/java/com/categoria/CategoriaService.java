package com.categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoriaService {

    private List<Categoria> categorias = new ArrayList<Categoria>(Arrays.asList(
            new Categoria("1", "Rock"),
            new Categoria("2", "Jazz"),
            new Categoria("3", "Blues")
    ));

    public List<Categoria> buscarTodas(){
        return categorias;
    }

    public Categoria buscarCategoria(String id){
        return categorias.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }

    public void adicionarCategoria(Categoria categoria){
        categorias.add(categoria);
    }
}
