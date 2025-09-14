package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.Cliente;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();

    public ClienteService() {
        clientes.add(new Cliente(1L, "João Pedro", "joao@example.com"));
        clientes.add(new Cliente(2L, "Maria Silva", "maria@example.com"));
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}
