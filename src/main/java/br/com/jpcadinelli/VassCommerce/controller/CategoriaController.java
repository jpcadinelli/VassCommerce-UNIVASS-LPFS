package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Categoria;
import br.com.jpcadinelli.VassCommerce.model.Produto;
import br.com.jpcadinelli.VassCommerce.service.CategoriaService;
import br.com.jpcadinelli.VassCommerce.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final ProdutoService produtoService;

    public CategoriaController(CategoriaService categoriaService, ProdutoService produtoService) {
        this.categoriaService = categoriaService;
        this.produtoService = produtoService;
    }

    // GET /categoria → listar todas
    @GetMapping
    public List<Categoria> listarCategorias(@RequestParam(required = false) String nome) {
        if (nome != null && !nome.isBlank()) {
            return categoriaService.buscarPorNome(nome);
        }
        return categoriaService.listarTodas();
    }

    // GET /categoria/{idcategoria}/produto?nome=&valorMinimo=&valorMaximo=
    @GetMapping("/{idcategoria}/produto")
    public List<Produto> listarProdutosFiltrados(
            @PathVariable Long idcategoria,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Float valorMinimo,
            @RequestParam(required = false) Float valorMaximo
    ) {
        return produtoService.listarPorCategoria(idcategoria, nome, valorMinimo, valorMaximo);
    }

}
