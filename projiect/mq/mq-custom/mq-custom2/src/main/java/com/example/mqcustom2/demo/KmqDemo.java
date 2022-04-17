package com.example.mqcustom2.demo;


import com.example.mqcustom2.core.KmqBroker;
import com.example.mqcustom2.core.KmqConsumer;
import com.example.mqcustom2.core.KmqMessage;
import com.example.mqcustom2.core.KmqProducer;
import lombok.SneakyThrows;

public class KmqDemo {

    @SneakyThrows
    public static void main(String[] args) {

        String topic = "kk.test";
        KmqBroker broker = new KmqBroker();
        broker.createTopic(topic);

        //消费者1开启
        KmqConsumer consumer = broker.createConsumer("consumer-01");
        consumer.subscribe(topic);
        final boolean[] flag = new boolean[1];
        flag[0] = true;
        new Thread(() -> {
            while (flag[0]) {
                KmqMessage<Order> message = consumer.poll(100);
                if(null != message) {
                    System.out.println("consumer-01:" + message.getBody());
                }
            }
            System.out.println("程序退出。");
        }).start();

        //生产者开启
        KmqProducer producer = broker.createProducer();
        for (int i = 0; i < 10; i++) {
            Order order = new Order(Long.parseLong(i+""), System.currentTimeMillis(), "USD2CNY", 6.51d);
            producer.send(topic, new KmqMessage(null, order));
        }
        Thread.sleep(500);


        //消费者2开启
        KmqConsumer consumer2 = broker.createConsumer("consumer-02");
        consumer2.subscribe(topic);
        final boolean[] flag2 = new boolean[1];
        flag2[0] = true;
        new Thread(() -> {
            while (flag2[0]) {
                KmqMessage<Order> message = consumer2.poll(10);
                if(null != message) {
                    System.out.println("consumer-02:" + message.getBody());
                }
            }
            System.out.println("程序退出。");
        }).start();
        Thread.sleep(500);

        System.out.println("点击任何键，发送一条消息；点击q或e，退出1消费者或者2消费者程序。");

        while (true) {
            char c = (char) System.in.read();
            if(c > 20) {
                System.out.println(c);
                producer.send(topic, new KmqMessage(null, new Order(100000L + c, System.currentTimeMillis(), "USD2CNY", 6.52d)));
            }
            if( c == 'q' ){
                flag[0] = false;
            }
            if( c == 'e' ){
                flag2[0] = false;
            }
            if(!flag[0] && !flag2[0]){
                break;
            }
        }



    }
}
