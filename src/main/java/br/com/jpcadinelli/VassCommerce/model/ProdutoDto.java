package br.com.jpcadinelli.VassCommerce.model;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class ProdutoDto {
    private Long id;
    private String nome;
    private String descricao;
    private String fotoUrl;
    private Date dataCadastro;
    private Date dataUltimaAtualizacao;
    private String valorUnitario;
    private Long idCategoria;

    public ProdutoDto() {}

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.fotoUrl = produto.getFotoUrl();
        this.dataCadastro = produto.getDataCadastro();
        this.dataUltimaAtualizacao = produto.getDataUltimaAtualizacao();
        this.valorUnitario = formatarCentavosParaReal(Long.valueOf(valorUnitario));
        this.idCategoria = produto.getIdCategoria();
    }

    public static String formatarCentavosParaReal(Long valorEmCentavos) {
        if (valorEmCentavos == null) return "R$ 0,00";
        double valor = valorEmCentavos / 100.0;
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoMoeda.format(valor);
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

    public String getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
