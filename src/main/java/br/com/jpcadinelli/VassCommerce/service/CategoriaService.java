package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    private final List<Categoria> categorias = new ArrayList<>();

    public CategoriaService() {
        categorias.add(new Categoria(1, "https://img.com/img.png", "Eletrônicos", "Produtos de tecnologia"));
        categorias.add(new Categoria(2, "https://img.com/img.png", "Roupas", "Moda masculina e feminina"));
        categorias.add(new Categoria(3, "https://img.com/img.png", "Livros", "Literatura em geral"));
    }

    public List<Categoria> listarTodas() {
        return categorias;
    }

    public List<Categoria> buscarPorNome(String nome) {
        return categorias.stream()
                .filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }

}
