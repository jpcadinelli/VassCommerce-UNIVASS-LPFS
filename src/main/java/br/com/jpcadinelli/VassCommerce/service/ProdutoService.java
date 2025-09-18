package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoService() {
        produtos.add(new Produto(1L, "Notebook Dell", "Notebook i7 com 16GB RAM",
                "https://exemplo.com/notebook.jpg",
                new Date(), new Date(), 4500.00F, 1L));

        produtos.add(new Produto(2L, "Smartphone Samsung", "Galaxy S22",
                "https://exemplo.com/smartphone.jpg",
                new Date(), new Date(), 3200.00F, 1L));

        produtos.add(new Produto(3L, "Camiseta Polo", "Camiseta de algodão",
                "https://exemplo.com/camiseta.jpg",
                new Date(), new Date(), 120.00F, 2L));

        produtos.add(new Produto(4L, "Livro - Java para Iniciantes", "Livro de programação",
                "https://exemplo.com/livro.jpg",
                new Date(), new Date(), 90.00F, 3L));
    }

    // Listar produtos por categoria
    public List<Produto> listarPorCategoria(Long categoriaId) {
        return produtos.stream()
                .filter(p -> p.getIdCategoria().equals(categoriaId))
                .toList();
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtos;
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Adicionar novo produto
    public Produto adicionarProduto(Produto produto) {
        Long novoId = produtos.isEmpty() ? 1L : produtos.get(produtos.size() - 1).getId() + 1;
        produto.setId(novoId);

        produto.setDataCadastro(new Date());
        produto.setDataUltimaAtualizacao(new Date());

        produtos.add(produto);
        return produto;
    }

}

