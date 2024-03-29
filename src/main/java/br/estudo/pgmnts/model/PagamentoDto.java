package br.estudo.pgmnts.model;

import java.io.Serializable;

import br.estudo.pgmnts.model.orm.Compra;

public class PagamentoDto implements Serializable {

	private static final long serialVersionUID = 1L;

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
                ", cdCompra:" + cdCompra +
                ", valor:" + valor +
                '}';
    }

	public Compra getCompra() {
		return new Compra(getCdCompra(), getValor());
	}
}
