package cl.mobdev.trainee.rickandmorty.gateway;

import cl.mobdev.trainee.rickandmorty.exception.CharacterNotFoundException;
import cl.mobdev.trainee.rickandmorty.models.Character;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultEndPointRootGatewayGateway implements GetEndpointRootGateway {

    private final String url;
    private final RestTemplate restTemplate;


    public ConsultEndPointRootGatewayGateway(@Value("${url}") String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public Character execute(int id) {
        Character character = null;
        ResponseEntity <Character> responseEntity;

        try {
            responseEntity = restTemplate.getForEntity(url+id, Character.class);
            character = responseEntity.getBody();
            //System.out.println(character);

        }catch (RestClientException ex){
            throw new CharacterNotFoundException("Character not found");
        }

        return character;
    }
}