package cl.pfequipo1.proyecto_final.service;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    private static final String API_URL = "http://tu-api-destino.com/api/v1/mensajes";

    @KafkaListener(topics = "iot-topic", groupId = "grupo-consumidor")
    public void consumeMessage(String message) {
        logger.info("Mensaje recibido de Kafka: {}", message);
        enviarMensajeAPI(message);
    }

    private void enviarMensajeAPI(String message) {
        try {
            Request.post(API_URL)
                    .bodyString(message, ContentType.APPLICATION_JSON)
                    .execute()
                    .returnContent();

            logger.info("Mensaje enviado a la API correctamente.");
        } catch (Exception e) {
            logger.error("Error al enviar el mensaje a la API: {}", e.getMessage(), e);
        }
    }
}

