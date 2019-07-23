package br.estudo.pgmnts.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.estudo.pgmnts.model.orm.ClienteConta;
import br.estudo.pgmnts.repository.ClienteContaJpaRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteContaJpaRepository repositorioDeCliente;

	public ClienteConta buscaClientePor(String docCliente) {
		return repositorioDeCliente.findByDocumento(docCliente);
	}

}
