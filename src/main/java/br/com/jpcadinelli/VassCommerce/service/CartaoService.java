package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.Cartao;
import br.com.jpcadinelli.VassCommerce.model.Categoria;
import br.com.jpcadinelli.VassCommerce.model.TipoCartao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CartaoService {
    private final List<Cartao> cartoes = new ArrayList<>();

    public CartaoService() {
        cartoes.add(new Cartao(1L, 1L, 1, new Date(), false));
        cartoes.add(new Cartao(2L, 2L, 2, new Date(), false));
        cartoes.add(new Cartao(3L, 1L, 2, new Date(), false));
    }

    public List<Cartao> listarPorCliente(Long idCliente) {
        return cartoes.stream()
                .filter(c -> Objects.equals(c.getIdCliente(), idCliente))
                .filter(c -> Boolean.FALSE.equals(c.getExcluido()))
                .toList();
    }

    public Cartao adicionarCartao(Long idCliente, Cartao cartao) {
        long novoId = cartoes.stream().mapToLong(Cartao::getId).max().orElse(0L) + 1;
        cartao.setId(novoId);
        cartao.setIdCliente(idCliente);
        cartoes.add(cartao);
        return cartao;
    }

    public Cartao atualizarCartao(Long idCliente, Long idCartao, Cartao atualizado) {
        Cartao cartao = cartoes.stream()
                .filter(c -> c.getId().equals(idCartao) && c.getIdCliente().equals(idCliente))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        cartao.setTipoCartao(atualizado.getTipoCartao());
        cartao.setDataCriacao(atualizado.getDataCriacao());
        cartao.setExcluido(atualizado.getExcluido());
        return cartao;
    }

    public void excluirCartao(Long idCliente, Long idCartao) {
        cartoes.stream()
                .filter(c -> c.getId().equals(idCartao) && c.getIdCliente().equals(idCliente))
                .findFirst()
                .ifPresent(c -> c.setExcluido(true));
    }
}
