package ir.javaclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BlockchainPeerApp {
    public static void main(String[] args) {
        SpringApplication.run(BlockchainPeerApp.class, args);
    }
}