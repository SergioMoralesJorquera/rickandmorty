package cl.mobdev.trainee.rickandmorty.exampleTDD5;

import cl.mobdev.trainee.rickandmorty.models.Character;
import cl.mobdev.trainee.rickandmorty.models.Origin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
*
* Tendrá un método que no recibe parámetros, usara un Gateway
* que trae un listado de characters y retornara ese listado de characteres
* ordenado por nombre,pero a los characteres que sean del planeta "Mars",
* se les reescribirá el atributo "type" usando lenguaje marcianousando como dato
* de entrada el nombre.
Algoritmo lenguaje marciano:Dado un texto cada vocal es
* reemplazada por un numero; a(1), e(2), i(3), o(4), u(5)
* todos los caracteres son minúsculas y sin espacios.
Por ejemplo, nombre "Hola Mundo" --> "h4l1m5nd4"
*
* */

@ExtendWith(MockitoExtension.class)
public class GetCharacterListTest {

    //clase con el caso de uso a desarrollar
    private GetCharacterList getCharacterList;
    private Character characterExpected1, characterExpected2;
    private Character characterResponse1, characterResponse2;
    private Origin origin1;
    private ArrayList<Character> expectedList;
    private ArrayList<Character> listCharacter;

    @Mock
    private CharacterListGateway characterListGateway;
    @Mock
    private MartianTranslate martianTranslate;


    @BeforeEach//algo que va estar mockiando evita usar las instancia
    void setUp(){
        this.getCharacterList= new GetCharacterList(characterListGateway, martianTranslate);
    }

    @Test
    void should_return_sort_list_of_characters_for_name(){

        //
        characterExpected1 = new Character();
        characterExpected1.setName("ana");
        characterExpected2 = new Character();
        characterExpected2.setName("barbara");

        expectedList = new ArrayList<>();

        expectedList.add(characterExpected1);
        expectedList.add(characterExpected2);

        //Given

        characterResponse1 = new Character();
        characterResponse1.setName("barbara");
        characterResponse2 = new Character();
        characterResponse2.setName("ana");

        listCharacter = new ArrayList<>();

        listCharacter.add(characterResponse1);
        listCharacter.add(characterResponse2);

        Mockito.when(characterListGateway.getCharacter()).thenReturn(listCharacter);

        //When
        //resivir la lista de objetos
        ArrayList<Character> response = getCharacterList.execute();

        //Then
        int i=0;
        for(Character character : expectedList){
            assertEquals(expectedList.get(i).getName(), response.get(i).getName());
            i++;
        }

        //assertEquals( expectedList.stream().forEach((eL)-> eL.getName()), response.stream().forEach((res)-> res.getName())  );

    }

    @Test
    void should_return_type_with_martian_language_from_origin_mars(){

        characterExpected1 = new Character();
        characterExpected1.setType("h3w4rld");

        expectedList = new ArrayList<>();
        expectedList.add(characterExpected1);

        //Given
        origin1 = new Origin();
        origin1.setName("Mars");

        characterResponse1 = new Character();
        characterResponse1.setOrigin(origin1);
        characterResponse1.setName("hi world");

        listCharacter = new ArrayList<>();
        listCharacter.add(characterResponse1);

        Mockito.when(characterListGateway.getCharacter()).thenReturn(listCharacter);
        Mockito.when(martianTranslate.execute(characterResponse1.getName())).thenReturn(characterExpected1.getType());

        //When
        ArrayList<Character> response = getCharacterList.execute();

        //Then
        assertEquals(expectedList.get(0).getType(), response.get(0).getType());

    }

    @Test
    void should_return_type_empty_when_character_is_not_mars(){

        characterExpected1 = new Character();
        characterExpected1.setType("");

        expectedList = new ArrayList<>();
        expectedList.add(characterExpected1);

        //Given
        origin1 = new Origin();
        origin1.setName("Earth");

        characterResponse1 = new Character();
        characterResponse1.setOrigin(origin1);
        characterResponse1.setName("hi world");

        listCharacter = new ArrayList<>();
        listCharacter.add(characterResponse1);

        Mockito.when(characterListGateway.getCharacter()).thenReturn(listCharacter);

        //When
        ArrayList<Character> response = getCharacterList.execute();

        //Then
        assertEquals(expectedList.get(0).getType(), response.get(0).getType());

    }

    @Test
    void should_return_list_empty_when_character_list_is_empty(){
        Integer sizeExpected = 0;

        //Given
        listCharacter = new ArrayList<>();

        Mockito.when(characterListGateway.getCharacter()).thenReturn(listCharacter);

        //When
        ArrayList<Character> response = getCharacterList.execute();

        //Then
        assertEquals(sizeExpected, response.size());

    }

}
