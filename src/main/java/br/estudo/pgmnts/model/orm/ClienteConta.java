package br.estudo.pgmnts.model.orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_conta_cliente")
public class ClienteConta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Integer id;

    @Column(name = "con_doc_cliente")
    private String documento;

    @Column(name = "con_saldo")
    private double saldo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "con_id")
    private List<Compra> compras = new ArrayList<>();

	
    public void debitoDoValor(double valorDoDebito) {
		if(valorDoDebito <= saldo) {saldo = (saldo - valorDoDebito);}
	}
	
	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "ClienteConta{id:" + id + ", documento:" + documento + ", saldo:" + saldo + "}";
	}
	
	

}
