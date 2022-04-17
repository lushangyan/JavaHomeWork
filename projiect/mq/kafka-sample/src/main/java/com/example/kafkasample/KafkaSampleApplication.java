package com.example.kafkasample;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaSampleApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String topic ="test32";
//        String server = "localhost:9092";
        //TODO 集群本地没配置好，所以暂时消费不了，但是集群节点这么
        String server = "localhost:9001,localhost:9002,localhost:9003";
        String message = "message-test";

        KafkaProducer<String, String> producer = KafkaUtils.createProducer(server);
        for (int i = 0; i < 2000; i++) {
            KafkaUtils.send(producer,topic,message + i);
        }

        KafkaConsumer<String, String> consumer = KafkaUtils.createConsumer(server, topic);
        KafkaUtils.readMessage(consumer,5L);
    }
}
