package br.com.jpcadinelli.VassCommerce.model;

import java.util.Date;

public class Pedido {
    private Long id;
    private Date dataCriacao;
    private Float valorTotal;

    public Pedido() {}

    public Pedido(Long id, Date dataCriacao, Float valorTotal) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
