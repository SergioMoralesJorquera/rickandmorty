package cl.mobdev.trainee.rickandmorty.exampleTDD4;

import cl.mobdev.trainee.rickandmorty.models.Character;
import cl.mobdev.trainee.rickandmorty.models.Location;
import cl.mobdev.trainee.rickandmorty.models.Origin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//ctrl+ alt + o = borra importas

/*Tendrá un método que dado un Character,retorna un true si
donde vive es el mismo lugar de su origen y false en cualquier otro caso.
Lanzara un LocationException si su origen es desconocido
Lanzara un LocationException si su locación es desconocido
Lanzara un LocationException si su origen y locación son desconocido*/

//@ExtendWith(MockitoExtension.class)
public class IsOriginSameLocationTest {

    private Character character;
    private Location location;
    private Origin origin;

    //@Mock tod lo que va en el constructor se mockea
    private IsOriginSameLocation isOriginSameLocation;

    @BeforeEach
    void setUp(){
        this.isOriginSameLocation = new IsOriginSameLocation();
        this.character = new Character();
        this.location = new Location();
        this.origin = new Origin();

    }

    @Test
    void should_return_true_when_origin_character_it_is_the_same_place_of_location() {

        boolean responseExpected = true;

        //Given
        location.setName("Earth");
        origin.setName("Earth");

        character.setLocation(location);
        character.setOrigin(origin);

        //when
        boolean response = isOriginSameLocation.execute(character);

        //then
        assertEquals(responseExpected, response);
    }

    @Test
    void should_return_false_when_origin_character_itis_the_different_place_of_origin() {
        boolean responseExpected = false;

        //Given
        location.setName("jupiter");
        origin.setName("Earth");

        character.setLocation(location);
        character.setOrigin(origin);

        //when
        boolean response = isOriginSameLocation.execute(character);

        //then
        assertEquals(responseExpected, response);
    }

    @Test
    void should_throw_exception_when_origin_is_unknown() {
        String responseExpected = "unknown origin";

        //Given
        location.setName("Earth");
        origin.setName("unknown");

        character.setLocation(location);
        character.setOrigin(origin);

        LocationException thrown = assertThrows(LocationException.class,()-> this.isOriginSameLocation.execute(character));
        //lo que espero que lance, una función lambda para que se ejecute

        //then
        assertEquals(responseExpected, thrown.getMessage());
    }

   @Test
    void should_throw_exception_when_location_is_unknown() {
       String responseExpected = "unknown location";

       //Given
       location.setName("unknown");
       origin.setName("Earth");

       character.setLocation(location);
       character.setOrigin(origin);

       //when
       LocationException thrown = assertThrows(LocationException.class,()-> this.isOriginSameLocation.execute(character));
       //lo que espero que lance, una función lambda para que se ejecute

       //then
       assertEquals(responseExpected, thrown.getMessage());
    }

    @Test
    void should_throw_exception_when_location_and_origin_is_unknown() {
        String responseExpected = "unknown location and origin";

        //Given
        location.setName("unknown");
        origin.setName("unknown");

        character.setLocation(location);
        character.setOrigin(origin);

        LocationException thrown = assertThrows(LocationException.class,()-> this.isOriginSameLocation.execute(character));
        //lo que espero que lance, una función lambda para que se ejecute

        //then
        assertEquals(responseExpected, thrown.getMessage());
    }


}
