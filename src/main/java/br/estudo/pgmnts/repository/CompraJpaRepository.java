package br.estudo.pgmnts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.estudo.pgmnts.model.orm.Compra;

@Repository
public interface CompraJpaRepository extends JpaRepository<Compra, Integer> {

}
