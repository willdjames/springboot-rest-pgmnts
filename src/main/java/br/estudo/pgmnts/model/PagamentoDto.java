package br.estudo.pgmnts.model;

import java.io.Serializable;

public class PagamentoDto implements Serializable {

    private String docCliente;

    private Integer cdCompra;

    private double valor;

    public String getDocCliente() {
        return docCliente;
    }

    public Integer getCdCompra() {
        return cdCompra;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "PagamentoDto{" +
                "docCliente:'" + docCliente + '\'' +
                ", cdCompra" + cdCompra +
                ", valor:" + valor +
                '}';
    }
}
