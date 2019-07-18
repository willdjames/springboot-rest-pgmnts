package br.estudo.pgmnts.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitCustomConfiguration {

    public static final String FILA_PAGAMENTOS = "fila_processo_pagamento";

    @Bean
    public Queue criaFilaEntradaPagamento(){
        return new Queue(FILA_PAGAMENTOS, true);
    }

    @Bean
    public RabbitTemplate configRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(getConversorMenssagem());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter getConversorMenssagem() {
        return new Jackson2JsonMessageConverter();
    }
}
