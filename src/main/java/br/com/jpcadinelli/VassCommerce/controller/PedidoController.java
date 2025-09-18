package br.com.jpcadinelli.VassCommerce.controller;

import br.com.jpcadinelli.VassCommerce.model.Pedido;
import br.com.jpcadinelli.VassCommerce.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public Pedido cadastrarPedido(@PathVariable Long idcliente, @RequestBody Pedido pedido) {
        return pedidoService.cadastrarPedido(idcliente, pedido);
    }
}

