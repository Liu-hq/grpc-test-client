package com.grpc.demo.config;

import com.alibaba.druid.support.json.JSONParser;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * Description: kafka 监听
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/21 11:15.
 *
 * @see
 */
@Component
public class Listener {
    @KafkaListener(topics = "grpc-test")
    public void schemeListen(ConsumerRecord<String, byte[]> record) {
        try {
            Optional<byte[]> kafkaMessage = Optional.ofNullable(record.value());
            if (kafkaMessage.isPresent()) {
                Object message = new String(kafkaMessage.get());
                if (!StringUtils.isEmpty(message)) {
                    Object obj = new JSONParser(message.toString()).parse();
                    System.out.println(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
