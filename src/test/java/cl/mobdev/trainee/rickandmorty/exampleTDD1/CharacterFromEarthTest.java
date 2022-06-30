package cl.mobdev.trainee.rickandmorty.exampleTDD1;

import cl.mobdev.trainee.rickandmorty.exampleTDD2.IsHuman;
import cl.mobdev.trainee.rickandmorty.models.Origin;
import cl.mobdev.trainee.rickandmorty.exampleTDD1.IsCharacterFromEarth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cl.mobdev.trainee.rickandmorty.models.Character;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

//caso de uso que character provenga del planeta tierra
public class CharacterFromEarthTest {

    //Fase 1 de instanciación del caso de uso a probar
    private IsCharacterFromEarth isCharacterFromEarth = new IsCharacterFromEarth();

    @Test
    void should_return_true_when_origin_is_from_earth(){
        boolean responseExpected = true;

        //Given - arrange
        Character character = new Character();
        Origin origin = new Origin();
        origin.setName("Earth");
        character.setOrigin(origin);

        //Fase 2 de ejecución
        //when - act
        boolean response = this.isCharacterFromEarth.execute(character);

        //fase 3 de comprobación
        //Then - assert
        assertEquals(responseExpected, response);
    }

    @Test
    void should_return_false_when_origin_is_from_other_planet(){
        boolean responseExpected = false;

        //Given
        Character character = new Character();
        Origin origin = new Origin();
        origin.setName("jupiter");
        character.setOrigin(origin);

        //when
        boolean response = this.isCharacterFromEarth.execute(character);

        //Then
        assertEquals(responseExpected, response);
    }
}
