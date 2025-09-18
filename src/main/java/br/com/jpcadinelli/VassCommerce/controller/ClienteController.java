package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Cartao;
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

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

    @GetMapping("/{idcliente}/formas-de-pagamento")
    public List<Cartao> listarFormasDePagamento(@PathVariable Long idcliente) {
        return cartaoService.listarPorCliente(idcliente);
    }

    @PostMapping(value = "/{idcliente}/formas-de-pagamento", consumes = "application/json", produces = "application/json")
    public Cartao adicionarFormaDePagamento(@PathVariable Long idcliente, @RequestBody Cartao cartao) {
        return cartaoService.adicionarCartao(idcliente, cartao);
    }

    @PutMapping(value = "/{idcliente}/formas-de-pagamento/{idformapagamento}", consumes = "application/json", produces = "application/json")
    public Cartao atualizarFormaDePagamento(
            @PathVariable Long idcliente,
            @PathVariable Long idformapagamento,
            @RequestBody Cartao cartao
    ) {
        return cartaoService.atualizarCartao(idcliente, idformapagamento, cartao);
    }

    @DeleteMapping("/{idcliente}/formas-de-pagamento/{idformapagamento}")
    public void deletarFormaDePagamento(
            @PathVariable Long idcliente,
            @PathVariable Long idformapagamento
    ) {
        cartaoService.excluirCartao(idcliente, idformapagamento);
    }
}
