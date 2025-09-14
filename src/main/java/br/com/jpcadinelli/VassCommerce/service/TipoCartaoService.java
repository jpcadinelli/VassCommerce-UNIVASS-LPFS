package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.TipoCartao;

import java.util.ArrayList;
import java.util.List;

public class TipoCartaoService {

    private final List<TipoCartao> tiposCartoes = new ArrayList<>();

    public TipoCartaoService() {
        tiposCartoes.add(new TipoCartao(1));
        tiposCartoes.add(new TipoCartao(2));
    }
}
