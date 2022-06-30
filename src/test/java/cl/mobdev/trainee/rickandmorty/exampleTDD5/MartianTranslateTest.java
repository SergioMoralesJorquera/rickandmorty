package cl.mobdev.trainee.rickandmorty.exampleTDD5;

import cl.mobdev.trainee.rickandmorty.exampleTDD6.IsListCharacterTotalTypeAlien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MartianTranslateTest {
    private MartianTranslate martianTranslate;

    @BeforeEach
    void setUp(){
        this.martianTranslate = new MartianTranslate();
    }

    @Test
    void should_return_string_with_alien_language(){
        String stringExpected = "h3w4rld";

        String stringResponse = "hi world";
        String response = this.martianTranslate.execute(stringResponse);

        //Then
        assertEquals(stringExpected, response);
    }

    @Test
    void should_return_string_empthy_when_names_string_is_empthy (){
        String stringExpected = "";

        String stringResponse = "";
        String response = this.martianTranslate.execute(stringResponse);

        //Then
        assertEquals(stringExpected, response);
    }

}
