package com.dapeng.play.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootApplication
public class HazelcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazelcastApplication.class, args);
    }

    @Bean
    @Profile("client")
    public CommandLineRunner bootstrapper(final HazelcastInstance hazelcast) {
        return (String... args) -> {
            IMap<Object, Object> messageMap = hazelcast.getMap("messageMap");

            IntStream.range(1, 1000).forEach(i -> messageMap.put(String.valueOf(i), UUID.randomUUID().toString()));
            IntStream.range(1, 1000).forEach(i -> System.out.println(i + "->" + messageMap.get(String.valueOf(i))));
        };
    }
}
