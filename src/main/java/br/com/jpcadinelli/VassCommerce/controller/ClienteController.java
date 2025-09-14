package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Cliente;
import br.com.jpcadinelli.VassCommerce.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // GET /cliente/{id} → carrega dados de um cliente
    @GetMapping("/cliente/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }
}
