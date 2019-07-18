package br.estudo.pgmnts.business;

import br.estudo.pgmnts.configuration.RabbitCustomConfiguration;
import br.estudo.pgmnts.model.PagamentoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private static final Logger log = LoggerFactory.getLogger(PagamentoService.class);

    @RabbitListener(queues = RabbitCustomConfiguration.FILA_PAGAMENTOS)
    public void recebePagamento(final PagamentoDto pagamento){
        log.info("PagamentoCliente: {}", pagamento.getDocCliente());
        log.info("PagamentoCompra: {}", pagamento.getCdCompra());
        log.info("PagamentoValor: {}", pagamento.getValor());
    }

}
