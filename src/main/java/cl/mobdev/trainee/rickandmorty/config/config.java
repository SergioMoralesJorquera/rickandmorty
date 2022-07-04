package cl.mobdev.trainee.rickandmorty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {
    @Bean//crea instancia de restamplate para ser usado en tod_o el programa
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
