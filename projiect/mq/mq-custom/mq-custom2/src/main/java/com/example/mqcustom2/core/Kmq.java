package com.example.mqcustom2.core;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Kmq {

    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new KmqMessage[capacity];
    }

    private String topic;

    private int capacity;

    private KmqMessage[] queue;

    private int pushOffet = 0;

    private Map<String,Integer> cuosumerReadOffet = new ConcurrentHashMap<>(64);

    public boolean send(KmqMessage message) {
        int i = pushOffet++;
        queue[i] = message;
        return true;
    }

    public KmqMessage poll(String cuosumerName) {
        cuosumerReadOffet.putIfAbsent(cuosumerName, 0);
        Integer readOffet = cuosumerReadOffet.get(cuosumerName);
        KmqMessage kmqMessage = queue[readOffet.intValue()];
        if(kmqMessage != null){
            readOffet++;
            cuosumerReadOffet.put(cuosumerName,readOffet);
        }
        return kmqMessage;
    }

    @SneakyThrows
    public KmqMessage poll(String cuosumerName,long timeout) {
        return poll(cuosumerName);
        //return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }

}
