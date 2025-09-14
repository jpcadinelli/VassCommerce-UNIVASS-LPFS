package br.com.jpcadinelli.VassCommerce.model;

import java.util.Date;

public class Cartao {
    private Long id;
    private Long idCliente;
    private int tipoCartao;
    private Date dataCriacao;
    private Boolean excluido;

    public Cartao() {}

    public Cartao(Long id, Long idCliente, int tipoCartao, Date dataCriacao, Boolean excluido) {
        this.id = id;
        this.idCliente = idCliente;
        this.tipoCartao = tipoCartao;
        this.dataCriacao = dataCriacao;
        this.excluido = excluido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public int getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(int tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public void setExcluido(Boolean excluido) {
        this.excluido = excluido;
    }
}
