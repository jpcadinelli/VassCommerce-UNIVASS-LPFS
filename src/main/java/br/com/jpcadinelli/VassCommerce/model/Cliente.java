package br.com.jpcadinelli.VassCommerce.model;

import java.util.Date;

public class Cliente {
    private Long id;
    private String cpf;
    private String fotoUrl;
    private Date DataNascimento;

    public Cliente() {}

    public Cliente(Long id, String cpf, String fotoUrl, Date dataNascimento) {
        this.id = id;
        this.cpf = cpf;
        this.fotoUrl = fotoUrl;
        DataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        DataNascimento = dataNascimento;
    }
}
