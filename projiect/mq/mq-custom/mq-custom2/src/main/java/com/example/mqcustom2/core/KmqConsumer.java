package com.example.mqcustom2.core;

public class KmqConsumer<T> {

    private final KmqBroker broker;

    private Kmq kmq;

    private String cuosumerName;


    public KmqConsumer(KmqBroker broker,String cuosumerName) {
        this.broker = broker;
        this.cuosumerName = cuosumerName;
    }

    public void subscribe(String topic) {
        this.kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public KmqMessage<T> poll(long timeout) {
        return kmq.poll(cuosumerName,timeout);
    }

}
