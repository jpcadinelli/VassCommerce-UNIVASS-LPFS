package br.com.jpcadinelli.VassCommerce.service;

import br.com.jpcadinelli.VassCommerce.model.Cidade;
import br.com.jpcadinelli.VassCommerce.model.Estado;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EstadoService {

    private final List<Estado> estados = new ArrayList<>();
    private final Map<Long, List<Cidade>> cidadesPorEstado = new HashMap<>();

    public EstadoService() {
        estados.add(new Estado(1L, "AC", "Acre"));
        estados.add(new Estado(2L, "AL", "Alagoas"));
        estados.add(new Estado(3L, "AP", "Amapá"));
        estados.add(new Estado(4L, "AM", "Amazonas"));
        estados.add(new Estado(5L, "BA", "Bahia"));
        estados.add(new Estado(6L, "CE", "Ceará"));
        estados.add(new Estado(7L, "DF", "Distrito Federal"));
        estados.add(new Estado(8L, "ES", "Espírito Santo"));
        estados.add(new Estado(9L, "GO", "Goiás"));
        estados.add(new Estado(10L, "MA", "Maranhão"));
        estados.add(new Estado(11L, "MT", "Mato Grosso"));
        estados.add(new Estado(12L, "MS", "Mato Grosso do Sul"));
        estados.add(new Estado(13L, "MG", "Minas Gerais"));
        estados.add(new Estado(14L, "PA", "Pará"));
        estados.add(new Estado(15L, "PB", "Paraíba"));
        estados.add(new Estado(16L, "PR", "Paraná"));
        estados.add(new Estado(17L, "PE", "Pernambuco"));
        estados.add(new Estado(18L, "PI", "Piauí"));
        estados.add(new Estado(19L, "RJ", "Rio de Janeiro"));
        estados.add(new Estado(20L, "RN", "Rio Grande do Norte"));
        estados.add(new Estado(21L, "RS", "Rio Grande do Sul"));
        estados.add(new Estado(22L, "RO", "Rondônia"));
        estados.add(new Estado(23L, "RR", "Roraima"));
        estados.add(new Estado(24L, "SC", "Santa Catarina"));
        estados.add(new Estado(25L, "SP", "São Paulo"));
        estados.add(new Estado(26L, "SE", "Sergipe"));
        estados.add(new Estado(27L, "TO", "Tocantins"));

        cidadesPorEstado.put(19L, List.of(
                new Cidade(1L, "Rio de Janeiro"),
                new Cidade(2L, "Niterói"),
                new Cidade(3L, "Vassouras"),
                new Cidade(4L, "Valença"),
                new Cidade(5L, "Barra do Piraí")
        ));

        cidadesPorEstado.put(25L, List.of(
                new Cidade(6L, "São Paulo"),
                new Cidade(7L, "Campinas"),
                new Cidade(8L, "Santos")
        ));
    }

    public List<Estado> listarEstados() {
        return estados;
    }

    public List<Cidade> listarCidadesPorEstado(Long idEstado) {
        return cidadesPorEstado.getOrDefault(idEstado, Collections.emptyList());
    }
}