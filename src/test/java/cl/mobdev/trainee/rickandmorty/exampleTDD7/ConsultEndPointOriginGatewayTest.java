package cl.mobdev.trainee.rickandmorty.exampleTDD7;
import cl.mobdev.trainee.rickandmorty.gateway.GetEndPointOriginGateway;
import cl.mobdev.trainee.rickandmorty.gateway.GetEndpointRootGateway;
import cl.mobdev.trainee.rickandmorty.models.Character;
import cl.mobdev.trainee.rickandmorty.models.Origin;
import cl.mobdev.trainee.rickandmorty.services.GetCharacterByIdGatewayUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultEndPointOriginGatewayTest {

    private GetCharacterByIdGatewayUseCase getCharacterByIdUseCase;

    //se mockea las dependencias
    @Mock
    private GetEndPointOriginGateway getEndPointOriginGateway;
    @Mock
    private GetEndpointRootGateway getEndpointRootGateway;

    @BeforeEach
    void setUp(){
        this.getCharacterByIdUseCase = new GetCharacterByIdGatewayUseCase(getEndpointRootGateway, getEndPointOriginGateway);
    }

    @Test
    void should_verify_origin_gateway_execute(){

        int timeExpected = 1;

        //Given
        Origin origin = new Origin();
        origin.setUrl("www.rickandmorty.com");

        Character character = new Character();
        character.setName("Morty");
        character.setEpisode(new ArrayList());
        character.setOrigin(origin);

        Mockito.when(getEndpointRootGateway.execute(1)).thenReturn(character);
        Mockito.when(getEndPointOriginGateway.execute("www.rickandmorty.com")).thenReturn(origin);

        //When
        Character response = getCharacterByIdUseCase.execute(1);

        //then
        verify(getEndPointOriginGateway, Mockito.times(timeExpected)).execute("www.rickandmorty.com");

    }

    @Test
    void should_verify_origin_gateway_not_execute(){

        //url no se presenta en location
        int timeExpected = 0;

        //Given
        Origin origin = new Origin();
        origin.setUrl("");

        Character character = new Character();
        character.setName("Morty");
        character.setEpisode(new ArrayList());
        character.setOrigin(origin);

        Mockito.when(getEndpointRootGateway.execute(1)).thenReturn(character);
        //Mockito.when(getEndPointOriginGateway.execute("www.rickandmorty.com")).thenReturn(origin);

        //When
        Character response = getCharacterByIdUseCase.execute(1);

        //then
        //verify(getEndPointOriginGateway, Mockito.times(timeExpected)).execute("");
        verify(getEndPointOriginGateway, never()).execute("");

    }
}
