package br.com.jpcadinelli.VassCommerce.model;

public class TipoCartao {
    private int tipo;

    public TipoCartao() {}

    public TipoCartao(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
