package br.estudo.pgmnts.model.orm;

import javax.persistence.*;

@Entity
@Table(name = "tb_compra")
public class Compra {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private Integer id;

    @Column(name = "comp_codigo")
    private Integer codigo;

    @Column(name = "comp_valor")
    private double valor;

    @Deprecated
    public Compra() {}
    
    public Compra(Integer cdCompra, double valorCompra) {
    	codigo = cdCompra;
    	valor = valorCompra;
    }
}
