package io.github.kimmking.gateway.router;

import io.github.kimmking.gateway.inbound.HttpInboundServer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RoundRobinHttpEndpointRouter implements HttpEndpointRouter{

    //1.定义map, key-ip,value-weight
    static Map<String,Integer> ipMap=null;

    public RoundRobinHttpEndpointRouter(){

    }

    @Override
    public String route(List<String> endpoints) {
        if(ipMap == null){
            ipMap = new HashMap<>();
            for (String backendUrl : endpoints) {
                ipMap.put(backendUrl,1);
            }
        }
        String s = RoundRobin();
        System.out.println("当前地址:" + s);
        return s;
    }

    //Integer sum=0;
    Integer  pos = 0;

    public String RoundRobin(){
        Map<String,Integer> ipServerMap=new ConcurrentHashMap<>();
        ipServerMap.putAll(ipMap);

        //2.取出来key,放到set中
        Set<String> ipset=ipServerMap.keySet();

        //3.set放到list，要循环list取出
        ArrayList<String> iplist=new ArrayList<String>();
        iplist.addAll(ipset);
        String serverName=null;

        //4.定义一个循环的值，如果大于set就从0开始
        synchronized(pos){
            if (pos>=ipset.size()){
                pos=0;
            }
            serverName=iplist.get(pos);
            //轮询+1
            pos ++;
        }
        return serverName;

    }

    public static void main(String[] args) {
        String proxyServers = System.getProperty("proxyServers","http://localhost:8801,http://localhost:8802");
        List<String> urls = Arrays.asList(proxyServers.split(","));
        RoundRobinHttpEndpointRouter testRoundRobin = new RoundRobinHttpEndpointRouter();
        for (int i=0;i<20;i++){
            testRoundRobin.route(urls);
        }
    }

}
