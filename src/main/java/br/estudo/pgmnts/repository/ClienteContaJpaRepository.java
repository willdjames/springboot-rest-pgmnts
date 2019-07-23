package br.estudo.pgmnts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.estudo.pgmnts.model.orm.ClienteConta;

@Repository
public interface ClienteContaJpaRepository extends JpaRepository<ClienteConta, Integer> {

	ClienteConta findByDocumento(String docCliente);

}
