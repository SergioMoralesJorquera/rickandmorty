package cl.mobdev.trainee.rickandmorty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RickandmortyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickandmortyApplication.class, args);
	}

	/*@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}*/

}
