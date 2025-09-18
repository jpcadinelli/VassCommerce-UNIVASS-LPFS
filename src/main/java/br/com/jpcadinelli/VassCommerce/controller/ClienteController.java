package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Cartao;
import br.com.jpcadinelli.VassCommerce.model.Cliente;
import br.com.jpcadinelli.VassCommerce.model.Pedido;
import br.com.jpcadinelli.VassCommerce.service.CartaoService;
import br.com.jpcadinelli.VassCommerce.service.ClienteService;
import br.com.jpcadinelli.VassCommerce.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final CartaoService cartaoService;
    private final PedidoService pedidoService;

    public ClienteController(ClienteService clienteService, CartaoService cartaoService, PedidoService pedidoService) {
        this.clienteService = clienteService;
        this.cartaoService = cartaoService;
        this.pedidoService = pedidoService;
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

    @GetMapping("/{idcliente}/pedido")
    public List<Pedido> listarPedidos(
            @PathVariable Long idcliente,
            @RequestParam(required = false) String datainicio,
            @RequestParam(required = false) String datafinal
    ) {
        if (datainicio != null && datafinal != null) {
            try {
                Date inicio = new Date(Long.parseLong(datainicio));
                Date fim = new Date(Long.parseLong(datafinal));
                return pedidoService.listarPedidosPorPeriodo(idcliente, inicio, fim);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Datas devem ser em timestamp (ms)");
            }
        }
        return pedidoService.listarPedidosPorCliente(idcliente);
    }
}
