package roon.practice.springintegrationkata;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.dsl.IntegrationFlow;

@SpringBootApplication
public class SpringIntegrationKataApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationKataApplication.class, args);
    }

}
