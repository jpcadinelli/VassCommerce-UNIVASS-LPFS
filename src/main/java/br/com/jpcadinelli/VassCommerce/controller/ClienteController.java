package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Cliente;
import br.com.jpcadinelli.VassCommerce.model.TipoCartao;
import br.com.jpcadinelli.VassCommerce.service.CartaoService;
import br.com.jpcadinelli.VassCommerce.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final CartaoService cartaoService;

    public ClienteController(ClienteService clienteService, CartaoService cartaoService) {
        this.clienteService = clienteService;
        this.cartaoService = cartaoService;
    }

    // GET /cliente/{id} → carrega dados de um cliente
    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    @GetMapping("/{id}/formas-de-pagamento")
    public List<TipoCartao> buscarFormasDePagamento(@PathVariable Long id) {
        return cartaoService.buscarFormasDePagamento(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
}
