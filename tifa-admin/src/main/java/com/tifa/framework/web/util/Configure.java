//package com.tifa.framework.web.util;
//
//
//import com.mongodb.client.MongoClient;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
////import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import redis.clients.jedis.Jedis;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Properties;
//
//@Configuration
//public class Configure {
//
//    private String mongoHost;
//    private int mongoPort;
//    private String esClusterName;
//    private String esHost;
//    private int esPort;
//    private String redisHost;
//
//    public Configure(){
//        this.mongoHost = "localhost";
//        this.mongoPort = 27017;
//        this.redisHost = "localhost";
//    }
//
//    @Bean(name = "mongoClient")
//    public MongoClient getMongoClient(){
//        MongoClient mongoClient = new MongoClient( mongoHost , mongoPort );
//        return mongoClient;
//    }
//
////    @Bean(name = "transportClient")
////    public TransportClient getTransportClient() throws UnknownHostException {
////        Settings settings = Settings.builder().put("cluster.name",esClusterName).build();
////        TransportClient esClient = new PreBuiltTransportClient(settings);
////        esClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(esHost), esPort));
////        return esClient;
////    }
//
//    @Bean(name = "jedis")
//    public Jedis getRedisClient() {
//        Jedis jedis = new Jedis(redisHost);
//        return jedis;
//    }
//}
