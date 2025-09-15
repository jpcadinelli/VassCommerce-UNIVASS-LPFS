package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Cidade;
import br.com.jpcadinelli.VassCommerce.model.Estado;
import br.com.jpcadinelli.VassCommerce.service.EstadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public List<Estado> listarEstados() {
        return estadoService.listarEstados();
    }

    @GetMapping("/{idEstado}/cidade")
    public List<Cidade> listarCidadesPorEstado(@PathVariable Long idEstado) {
        return estadoService.listarCidadesPorEstado(idEstado);
    }
}
