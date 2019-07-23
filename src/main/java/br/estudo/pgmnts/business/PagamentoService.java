package br.estudo.pgmnts.business;

import br.estudo.pgmnts.configuration.RabbitCustomConfiguration;
import br.estudo.pgmnts.model.PagamentoDto;
import br.estudo.pgmnts.model.orm.ClienteConta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagamentoService {

    private static final Logger log = LoggerFactory.getLogger(PagamentoService.class);
	
    @Autowired
    private ClienteService clienteService;

    @RabbitListener(queues = RabbitCustomConfiguration.FILA_PAGAMENTOS)
    @Transactional
    public void recebeDaFilaDePagamentos(final PagamentoDto solicitacaoDePagamento){
       
    	log.info("Solicitacao de Pagamento: {}", solicitacaoDePagamento);
        
        ClienteConta cliente = clienteService.buscaClientePor(solicitacaoDePagamento.getDocCliente());

        log.info("Cliente: {}", cliente);
        
        if(cliente == null) {
        	log.info("Cliente nao cadastrado no banco de dados");
        	return;
        }
                
        cliente.debitoDoValor(solicitacaoDePagamento.getValor());
        
        log.info("Saldo do cliente após débito: {}", cliente.getSaldo());
    }

}
