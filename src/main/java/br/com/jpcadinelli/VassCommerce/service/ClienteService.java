package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.Cliente;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();

    public ClienteService() {
        clientes.add(new Cliente(1L, "123.234.345-45", "https://exemplo.com/foto-joao.jpg", new GregorianCalendar(1991, Calendar.JUNE, 22).getTime()));

        clientes.add(new Cliente(2L, "987.654.321-00", "https://exemplo.com/foto-maria.jpg", new GregorianCalendar(1990, Calendar.JUNE, 22).getTime()
        ));
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> {
                    c.setCpf(clienteAtualizado.getCpf());
                    c.setFotoUrl(clienteAtualizado.getFotoUrl());
                    c.setDataNascimento(clienteAtualizado.getDataNascimento());
                    return c;
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    public void deletarCliente(Long id) {
        boolean removido = clientes.removeIf(c -> c.getId().equals(id));
        if (!removido) {
            throw new RuntimeException("Cliente não encontrado com id: " + id);
        }
    }
}
