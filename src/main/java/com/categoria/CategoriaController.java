package com.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("/categorias")
    public List<Categoria> buscarTodasCategorias(){
        return categoriaService.buscarTodas();
    }

    @RequestMapping("/categorias/{id}")
    public Categoria buscarCategoria(@PathVariable String id){
        return categoriaService.buscarCategoria(id);
    }
}
