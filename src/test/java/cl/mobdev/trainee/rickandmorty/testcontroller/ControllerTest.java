package cl.mobdev.trainee.rickandmorty.testcontroller;
import cl.mobdev.trainee.rickandmorty.controller.Controller;
import cl.mobdev.trainee.rickandmorty.exception.CharacterNotFoundException;
import cl.mobdev.trainee.rickandmorty.mocks.MockCharacter;
import cl.mobdev.trainee.rickandmorty.models.Character;
import cl.mobdev.trainee.rickandmorty.services.GetCharacterByIdGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    private Controller controller;

    @Mock
    private GetCharacterByIdGateway getCharacterByIdGateway;

    @BeforeEach
    void setUp(){
        this.controller = new Controller(getCharacterByIdGateway);
    }


    @Test
    void should_return_response_status_200_when_request_ok(){

        int statusExpected=200;

        //Given

        //Character character = new Character();
        //character.setName("Morty");

        Character character = MockCharacter.getCharacterStatus();

        Mockito.when(getCharacterByIdGateway.execute(1)).thenReturn(character);

        //When
        ResponseEntity<Character> response = controller.getCharactersForId(1);

        //Then
        assertEquals(statusExpected, response.getStatusCodeValue());

    }

    @Test
    void should_verify_call_method_getCharacterById_once_time(){

        //int timeExpected = 1;

        //Given
        Character character = MockCharacter.getCharacterStatus();//se utilizo el mismo 
        Mockito.when(getCharacterByIdGateway.execute(1)).thenReturn(character);

        //When
        ResponseEntity<Character> response = controller.getCharactersForId(1);

        //se invoque por una vez el método
        //Then
        verify(getCharacterByIdGateway).execute(1);
        verify(getCharacterByIdGateway, only()).execute(1);
        verify(getCharacterByIdGateway,atLeastOnce()).execute(1);

    }

    @Test
    void should_verify_trown_exception_when_character_not_found(){

        //Given
        Character character = MockCharacter.getCharacterStatus();
        Mockito.when(getCharacterByIdGateway.execute(1)).thenThrow(CharacterNotFoundException.class);

        //when-then
        assertThrows(CharacterNotFoundException.class, ()-> controller.getCharactersForId(1));

        //se invoque por una vez el método
        //Then
        //verify(getCharacterById).execute(1);

    }

}
