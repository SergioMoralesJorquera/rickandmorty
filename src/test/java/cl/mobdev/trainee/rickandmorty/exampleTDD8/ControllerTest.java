package cl.mobdev.trainee.rickandmorty.exampleTDD8;
import cl.mobdev.trainee.rickandmorty.controller.Controller;
import cl.mobdev.trainee.rickandmorty.exception.CharacterNotFoundException;
import cl.mobdev.trainee.rickandmorty.mocks.MockCharacter;
import cl.mobdev.trainee.rickandmorty.models.Character;
import cl.mobdev.trainee.rickandmorty.services.GetCharacterById;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    private Controller controller;

    @Mock
    private GetCharacterById getCharacterById;

    @BeforeEach
    void setUp(){
        this.controller = new Controller(getCharacterById);
    }


    @Test
    void should_return_ok_status(){

        int statusExpected=200;

        //Given

        //Character character = new Character();
        //character.setName("Morty");

        Character character = MockCharacter.getCharacterStatus();

        Mockito.when(getCharacterById.execute(1)).thenReturn(character);

        //When
        ResponseEntity<Character> response = controller.getCharactersForId(1);

        //Then
        assertEquals(statusExpected, response.getStatusCodeValue());

    }

    @Test
    void should_call_getCharacterById_once(){

        //int timeExpected = 1;

        //Given
        Character character = MockCharacter.getCharacterStatus();//se utilizo el mismo 
        Mockito.when(getCharacterById.execute(1)).thenReturn(character);

        //When
        ResponseEntity<Character> response = controller.getCharactersForId(1);

        //se invoque por una vez el método
        //Then
        verify(getCharacterById).execute(1);

    }

    @Test
    void should_verify_trown_exception(){


        //Given
        Character character = MockCharacter.getCharacterStatus();
        Mockito.when(getCharacterById.execute(1)).thenThrow(CharacterNotFoundException.class);

        //when-then
        assertThrows(CharacterNotFoundException.class, ()-> controller.getCharactersForId(1));


        //se invoque por una vez el método
        //Then
        //verify(getCharacterById).execute(1);

    }

}
