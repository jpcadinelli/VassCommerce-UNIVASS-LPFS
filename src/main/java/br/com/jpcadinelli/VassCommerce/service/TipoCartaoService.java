package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.Produto;
import br.com.jpcadinelli.VassCommerce.model.TipoCartao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoCartaoService {

    private final List<TipoCartao> tiposCartoes = new ArrayList<>();

    public TipoCartaoService() {
        tiposCartoes.add(new TipoCartao(1));
        tiposCartoes.add(new TipoCartao(2));
    }

    public List<TipoCartao> listarTodos() {
        return tiposCartoes.stream().toList();
    }
}
