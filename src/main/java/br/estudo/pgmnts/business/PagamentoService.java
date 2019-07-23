package br.estudo.pgmnts.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.estudo.pgmnts.configuration.RabbitCustomConfiguration;
import br.estudo.pgmnts.model.PagamentoDto;
import br.estudo.pgmnts.model.orm.ClienteConta;
import br.estudo.pgmnts.model.orm.Compra;

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
                
        try {
        	cliente.debitoDoValor(solicitacaoDePagamento.getValor());        	
        }catch (RuntimeException e) {
			log.error(e.getMessage());
			return;
		}
        
        log.info("Saldo do cliente após débito: {}", cliente.getSaldo());
        
        Compra compraEfetuda = solicitacaoDePagamento.getCompra();
        
        cliente.adicionaCompra(compraEfetuda);
    }

}
