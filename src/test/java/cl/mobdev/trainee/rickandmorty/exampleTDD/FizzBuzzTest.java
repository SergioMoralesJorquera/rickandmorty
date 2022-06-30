package cl.mobdev.trainee.rickandmorty.exampleTDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    //método que reciba un input int y retorna un string
    //pero si es multiplo de 3 retorna fizz
    //pero si es multiplo de 5 retora buzz
    //en caso de que el input es multiplo de 3 y 5 retorna fizzbuzz
        
    
    //mockito

    private FizzBuzz fizzBuzz;
    @BeforeEach //se ejecuta antes de cada test. Normalmente se utiliza para preparar el entorno de testing
    void setUp(){
        this.fizzBuzz = new FizzBuzz();
    }


    //fase 1
    //FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void should_return_correct_output_for_input() {
        String expected = "0";
        String response = fizzBuzz.execute(0);
        assertEquals(expected, response);
    }
    @Test
    void should_return_fizz_when_input_is_multiple_by_3() {
        int inputTest=3;
        String expected = "Fizz";
        String response = fizzBuzz.execute(inputTest);
        assertEquals(expected, response);
    }

    @Test
    void should_return_buzz_when_input_is_multiple_by_5() {
        int inputTest=5;
        String expected = "Buzz";
        String response = fizzBuzz.execute(inputTest);
        assertEquals(expected, response);
    }

    @Test
    void should_return_fizzbuzz_when_input_is_multiple_by_5() {
        int inputTest=15;
        String expected = "FizzBuzz";
        String response = fizzBuzz.execute(inputTest);
        assertEquals(expected, response);
    }

}