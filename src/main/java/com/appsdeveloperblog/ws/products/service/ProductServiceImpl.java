package com.appsdeveloperblog.ws.products.service;

import com.appsdeveloperblog.ws.products.rest.CreateProductRestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;

@Service
public class ProductServiceImpl implements ProductService {
    KafkaTemplate<String, ProductCreateEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ProductServiceImpl(KafkaTemplate<String, ProductCreateEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductRestModel productRestModel) {
        String productId = UUID.randomUUID().toString();
        // TODO: Persist product to database before publishing event

        ProductCreateEvent productCreatedEvent = new ProductCreateEvent(
                productId,
                productRestModel.getTitle(),
                productRestModel.getPrice(),
                productRestModel.getQuantity());

        LOGGER.info("Before publishing event to Kafka");
        CompletableFuture<SendResult<String, ProductCreateEvent>> future =
                kafkaTemplate.send("topic2", productId, productCreatedEvent);
        future.whenComplete((result, exception) -> {
            if (exception != null) {
                LOGGER.error("Failed to send ProductCreateEvent for productId: {} ", productId, exception);
            } else if (result != null) {
                LOGGER.info("Message sent to Kafka: topic={}, partition={}, offset={}",
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            }
        });

        // Optionally, do not block here. If you need metadata synchronously, keep future.get().
        //future.get(); // Blocking call, consider removing for higher throughput.

        return productId;
    }
}
