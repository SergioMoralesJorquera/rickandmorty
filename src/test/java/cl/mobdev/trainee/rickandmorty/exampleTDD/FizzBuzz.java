package cl.mobdev.trainee.rickandmorty.exampleTDD;

public class FizzBuzz {
    public String execute(int input) {
        //return "";                            1)que la prueba falle
        //return String.valueOf(input);    //   2) Codigo mínimo para que la prueba pase
                                           //   3) La prueba debe pasar y refactorizar (mejorar código)

        if (input <1){
            return "0";
        }

        if(input % 15 ==0){
            return "FizzBuzz";
        }

        if(input % 3 ==0){
            return "Fizz";
        }

        if(input % 5 ==0){
            return "Buzz";
        }

        return String.valueOf(input);
    }
}
