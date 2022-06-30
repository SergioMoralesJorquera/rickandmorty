package cl.mobdev.trainee.rickandmorty.exampleTDD6;

import cl.mobdev.trainee.rickandmorty.models.Character;
import cl.mobdev.trainee.rickandmorty.models.Origin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Usar reduce

// Asumiendo que el objeto 'Character' tiene un campo 'Location'
// y este a su vez tiene un campo con un array de 'residents
//Tendrá un método que dado un listado de Characters,retorna un entero
//con el total de residentes de las locaciones de los caracteres de la especie "Alien"

public class IsListCharacterTotalTypeAlienTest {

    //clase con el caso de uso a desarrollar
    private IsListCharacterTotalTypeAlien isListCharacterTotalTypeAlien;
    private Character characterResponse1, characterResponse2, characterResponse3;

    private Origin origin1;

    @BeforeEach
    void setUp(){
        this.isListCharacterTotalTypeAlien = new IsListCharacterTotalTypeAlien();

    }

    @Test
    void should_return_number_of_residents_of_spice_aliens_of_list_character(){

        int intExpected = 6; //cantidad de residentes totales por especie alien

        //Given
        ArrayList resident = new ArrayList<>();
        resident.add("residentOrigin1");
        resident.add("residentOrigin2");
        resident.add("residentOrigin3");

        origin1 = new Origin();
        origin1.setResidents(resident);

        characterResponse1 = new Character();
        characterResponse1.setOrigin(origin1);
        characterResponse1.setSpecies("alien");

        characterResponse2 = new Character();
        characterResponse2.setOrigin(origin1);
        characterResponse2.setSpecies("human");

        characterResponse3 = new Character();
        characterResponse3.setOrigin(origin1);
        characterResponse3.setSpecies("alien");

        ArrayList<Character> responseListCharacter = new ArrayList<>();

        responseListCharacter.add(characterResponse1);
        responseListCharacter.add(characterResponse2);
        responseListCharacter.add(characterResponse3);

        //when
        int response = this.isListCharacterTotalTypeAlien.execute(responseListCharacter);

        //Then
        assertEquals(intExpected, response);




    }





}
