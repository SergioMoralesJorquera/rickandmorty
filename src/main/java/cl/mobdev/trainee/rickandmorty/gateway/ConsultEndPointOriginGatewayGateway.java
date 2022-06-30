package cl.mobdev.trainee.rickandmorty.gateway;

import cl.mobdev.trainee.rickandmorty.models.Origin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsultEndPointOriginGatewayGateway implements GetEndPointOriginGateway {

    private final RestTemplate restTemplate;
    private final Origin origin;

    //inyeccion de dependecia en el que suministra objetos a una clase
    //En lugar de ser la propia clase cree dichos objetos
    public ConsultEndPointOriginGatewayGateway(RestTemplate restTemplate, Origin origin) {
        this.restTemplate = restTemplate;
        this.origin = origin;
    }

    //método sobreescrito de la interfaz
    @Override
    public Origin execute(String url) {

        Origin origin = null;
        ResponseEntity<Origin> responseEntity;

        //consulta al endpoint location para generar objeto Origin
        responseEntity = restTemplate.getForEntity(url, Origin.class);

        //obtengo el objeto origin con los datos consultados al endpoint
        origin = responseEntity.getBody();
        return origin;
    }

}
