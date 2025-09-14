package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Produto;
import br.com.jpcadinelli.VassCommerce.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // GET /categoria/{idcategoria}/produto → listar produtos da categoria
    @GetMapping("/categoria/{idcategoria}/produto")
    public List<Produto> listarProdutosPorCategoria(@PathVariable Long idcategoria) {
        return produtoService.listarPorCategoria(idcategoria);
    }

    // GET /produto → listar todos os produtos
    @GetMapping("/produto")
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodos();
    }

    // GET /produto/{id} → carrega dados de um produto
    @GetMapping("/produto/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

}
