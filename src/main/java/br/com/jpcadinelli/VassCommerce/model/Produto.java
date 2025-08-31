package br.com.jpcadinelli.VassCommerce.model;

import java.util.Date;
import java.util.List;

public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private String fotoUrl;
    private Date dataCadastro;
    private Date dataUltimaAtualizacao;
    private Long valorUnitario;
    private Long idCategoria;

    public Produto() {}

    public Produto(Long id, String nome, String descricao, String fotoUrl, Date dataCadastro, Date dataUltimaAtualizacao, Long valorUnitario, Long idCategoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.fotoUrl = fotoUrl;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.valorUnitario = valorUnitario;
        this.idCategoria = idCategoria;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<ProdutoDto> ToResponse() {
        // transformar produto em produtoDto
    }
}
