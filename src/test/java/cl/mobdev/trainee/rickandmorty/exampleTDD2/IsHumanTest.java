package cl.mobdev.trainee.rickandmorty.exampleTDD2;

/* Tendrá un método que dado un id,usara un gateway
   que trae un charactery retorna un "true" si es
   humano y false en otro caso */

import cl.mobdev.trainee.rickandmorty.models.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IsHumanTest {

    private IsHuman isHuman;
    @Mock
    private CharacterGateway characterGateway; //interrfaz

    @BeforeEach
    void setUp(){//inicializa variables para ser reutilizadas
        this.isHuman = new IsHuman(characterGateway);
    }

    @Test
    void should_return_true_when_character_is_human(){
        boolean responseExpected = true;

        //Given
        int id = 1;
        Character character = new Character();
        character.setSpecies("Human");
        //cuando se llame el metodo de la interfaz, getId debe retornar un objeto de tipo caracter
        //este objeto caracter va con su atributo species seteado a human
        //le otorga un comportamiento como objeto caracter
        Mockito.when(this.characterGateway.getId(id)).thenReturn(character);

        //when
        boolean response = this.isHuman.execute(id);

        //then
        assertEquals(responseExpected, response);
    }

    @Test
    void should_return_false_when_character_is_human(){
        boolean responseExpected = false;

        //Given
        int id = 1;
        Character character = new Character();
        character.setSpecies("noHuman");
        //cuando se llame el metodo de la interfaz, getId debe retornar un objeto de tipo caracter
        //este objeto caracter va con su atributo species seteado a human
        //le otorga un comportamiento como objeto caracter
        Mockito.when(this.characterGateway.getId(id)).thenReturn(character);

        //when
        boolean response = this.isHuman.execute(id);

        //then
        assertEquals(responseExpected, response);
    }



}
