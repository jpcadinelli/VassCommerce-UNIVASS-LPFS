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

    public List<Produto> listarPorCategoria(Long categoriaId, String nome, Float valorMinimo, Float valorMaximo) {
        return produtos.stream()
                .filter(p -> p.getIdCategoria().equals(categoriaId))
                .filter(p -> nome == null || p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .filter(p -> valorMinimo == null || p.getValorUnitario() >= valorMinimo)
                .filter(p -> valorMaximo == null || p.getValorUnitario() <= valorMaximo)
                .toList();
    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Produto adicionarProduto(Produto produto) {
        Long novoId = produtos.isEmpty() ? 1L : produtos.get(produtos.size() - 1).getId() + 1;
        produto.setId(novoId);

        produto.setDataCadastro(new Date());
        produto.setDataUltimaAtualizacao(new Date());

        produtos.add(produto);
        return produto;
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(p -> {
                    p.setNome(produtoAtualizado.getNome());
                    p.setDescricao(produtoAtualizado.getDescricao());
                    p.setFotoUrl(produtoAtualizado.getFotoUrl());
                    p.setValorUnitario(produtoAtualizado.getValorUnitario());
                    p.setIdCategoria(produtoAtualizado.getIdCategoria());
                    p.setDataUltimaAtualizacao(new Date());
                    return p;
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    public void deletarProduto(Long id) {
        boolean removido = produtos.removeIf(p -> p.getId().equals(id));
        if (!removido) {
            throw new RuntimeException("Produto não encontrado com id: " + id);
        }
    }

}

