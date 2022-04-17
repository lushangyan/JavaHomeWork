package com.example.kafkasample;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaUtils {


    public static KafkaConsumer<String, String> createConsumer(String server, String topic) {
        Properties properties = new Properties();
//        properties.put("enable.auto.commit", false);
//        properties.put("isolation.level", "read_committed");
//        properties.put("auto.offset.reset", "latest");
        properties.put("group.id", "java1-kimmking");
        properties.put("bootstrap.servers", server);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer consumer = new KafkaConsumer(properties);
        consumer.subscribe(Collections.singletonList(topic));
        return consumer;
    }

    public static void readMessage(KafkaConsumer<String, String> consumer, Long timeout) {

        while (true) { //拉取数据

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(timeout));
            for (ConsumerRecord<String, String> record : records) {
                String value = record.value();
                System.out.println("收到消息:" + value);
            }
        }
    }

    public static KafkaProducer<String, String> createProducer(String server) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", server);
//        properties.put("queue.enqueue.timeout.ms", -1);
//        properties.put("enable.idempotence", true);
//        properties.put("transactional.id", "transactional_1");
//        properties.put("acks", "all");
//        properties.put("retries", "3");
//        properties.put("max.in.flight.requests.per.connection", 1);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        return producer;
    }

    public static void send(KafkaProducer<String, String> producer, String topic, String message) {
//        ProducerRecord record = new ProducerRecord(topic, message);
//        producer.send(record);

        ProducerRecord record = new ProducerRecord(topic, message, message);
        producer.send(record, (metadata, exception) -> {
//                if (exception != null) {
//                    producer.abortTransaction();
//                    throw new KafkaException(exception.getMessage() + " , data: " + record);
//                }
        });
    }


}
