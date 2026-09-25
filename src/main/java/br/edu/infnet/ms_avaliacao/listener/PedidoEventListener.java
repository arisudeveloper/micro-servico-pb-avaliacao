package br.edu.infnet.ms_avaliacao.listener;

import br.edu.infnet.ms_avaliacao.config.RabbitMQConfig;
import br.edu.infnet.ms_avaliacao.dto.PedidoCriadoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoEventListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PEDIDOS)
    public void receberEventoPedidoCriado(PedidoCriadoEvent event) {
        System.out.println("Evento recebido no MS-Avaliacao:");
        System.out.println("Pedido ID: " + event.getPedidoId());
        System.out.println("Restaurante ID: " + event.getRestauranteId());
        System.out.println("Valor Total: " + event.getValorTotal());
    }
}