package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private final List<Pedido> pedidos = new ArrayList<>();

    public Pedido cadastrarPedido(Long idCliente, Pedido pedido) {
        long novoId = pedidos.stream().mapToLong(Pedido::getId).max().orElse(0L) + 1;
        pedido.setId(novoId);
        pedido.setDataCriacao(new Date());
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidosPorCliente(Long idCliente) {
        return pedidos;
    }

    public List<Pedido> listarPedidosPorPeriodo(Long idCliente, Date inicio, Date fim) {
        return pedidos.stream()
                .filter(p -> !p.getDataCriacao().before(inicio) && !p.getDataCriacao().after(fim))
                .collect(Collectors.toList());
    }
}
