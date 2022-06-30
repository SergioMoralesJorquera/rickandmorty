package cl.mobdev.trainee.rickandmorty.exampleTDD3;


import cl.mobdev.trainee.rickandmorty.models.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*Tendrá un método que dado un id,usara un gateway que trae un character y retorna
el Character si es "female"o lanza una GenderException en otro
caso con un mensaje que dice "El character no es mujer"*/


@ExtendWith(MockitoExtension.class)
public class IsFemaleCharacterTest {

    private IsFemaleCharacter isFemaleCharacter;//clase a desarrollar
    @Mock
    private FemaleCharacterGateway itfFemaleCharacterGateway;//interrfaz

    @BeforeEach
    void setUp(){
        this.isFemaleCharacter = new IsFemaleCharacter(itfFemaleCharacterGateway);
    }

    @Test
    void should_return_character_when_character_is_female() {
        //Character responseExpected = new Character();
        //responseExpected.setType("female");

        String typeExpected = "female";

        //Given
        int id = 1;
        Character newCharacter = new Character();
        newCharacter.setGender("female");
        //retorna un objeto de tipo caracter por medio de interfaz
        Mockito.when(this.itfFemaleCharacterGateway.getId(id)).thenReturn(newCharacter);//devuelve un new character

        //when
        Character response = this.isFemaleCharacter.execute(id);

        //then
        assertEquals(typeExpected, response.getGender());
    }

    @Test
    void should_throw_exception_when_is_not_female()  {
        //GenderException exceptionExpected = new GenderException("El character no es mujer");
        String exceptionExpected = "El character no es mujer";

        //Given
        int id = 1;
        Character character = new Character();
        character.setGender("male");
        Mockito.when(this.itfFemaleCharacterGateway.getId(id)).thenReturn(character);//comportamiento al gateway y en otros casos a las dependencia

        //when
        GenderException thrown = assertThrows(GenderException.class,()->isFemaleCharacter.execute(id));
        //lo que espero que lance, una función lambda para que se ejecute

        //then
        assertEquals(exceptionExpected, thrown.getMessage());
    }

}
