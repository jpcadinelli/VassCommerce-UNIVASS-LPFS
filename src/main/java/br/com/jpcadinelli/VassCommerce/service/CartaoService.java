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

    public List<TipoCartao> buscarFormasDePagamento(Long id) {
        return cartoes.stream()
                .filter(c -> Objects.equals(c.getIdCliente(), id))
                .filter(c -> Boolean.FALSE.equals(c.getExcluido()))
                .map(Cartao::getTipoCartao)
                .distinct()
                .map(TipoCartao::new)
                .collect(Collectors.toList());
    }
}
