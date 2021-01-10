package br.com.zoota.microservice.fornecedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = "br.com.zoota.microservice.fornecedor")
@EnableJpaRepositories(basePackages = "br.com.zoota.microservice.fornecedor.repository")
public class FornecedorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FornecedorApplication.class, args);
    }
}
