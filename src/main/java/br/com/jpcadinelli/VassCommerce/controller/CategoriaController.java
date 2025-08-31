package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Categoria;
import br.com.jpcadinelli.VassCommerce.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // GET /categoria → listar todas
    @GetMapping
    public List<Categoria> listarCategorias(@RequestParam(required = false) String nome) {
        if (nome != null && !nome.isBlank()) {
            return categoriaService.buscarPorNome(nome);
        }
        return categoriaService.listarTodas();
    }
}
