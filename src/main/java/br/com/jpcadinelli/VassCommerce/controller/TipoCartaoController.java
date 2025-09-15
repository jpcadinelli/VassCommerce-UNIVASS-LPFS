package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.TipoCartao;
import br.com.jpcadinelli.VassCommerce.service.TipoCartaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-cartao")
public class TipoCartaoController {

    private final TipoCartaoService tipoCartaoService;

    public TipoCartaoController(TipoCartaoService tipoCartaoService) {
        this.tipoCartaoService = tipoCartaoService;
    }

    @GetMapping
    public List<TipoCartao> listarTodos() {
        return tipoCartaoService.listarTodos();
    }

}
