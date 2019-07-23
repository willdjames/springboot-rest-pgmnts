package br.estudo.pgmnts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.estudo.pgmnts.model.orm.ClienteConta;

@Repository
public interface ClienteContaJpaRepository extends JpaRepository<ClienteConta, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT c FROM ClienteConta c LEFT JOIN FETCH c.compras z WHERE c.documento = :docCliente")
	ClienteConta findByDocumento(String docCliente);

}
