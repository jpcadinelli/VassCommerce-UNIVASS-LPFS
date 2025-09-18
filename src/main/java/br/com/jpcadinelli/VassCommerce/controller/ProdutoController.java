package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Produto;
import br.com.jpcadinelli.VassCommerce.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // GET /produto → listar todos os produtos
    @GetMapping("")
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodos();
    }

    // GET /produto/{id} → carrega dados de um produto
    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    // POST /produto → cadastrar novo produto
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

}
