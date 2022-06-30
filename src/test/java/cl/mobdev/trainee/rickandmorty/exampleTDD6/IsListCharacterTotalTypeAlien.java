package cl.mobdev.trainee.rickandmorty.exampleTDD6;
import cl.mobdev.trainee.rickandmorty.models.Character;
import java.util.ArrayList;


public class IsListCharacterTotalTypeAlien {

    private String ALIEN = "alien";

    public int execute(ArrayList<Character> character){

        return character.stream()
                .filter(ch -> ch.getSpecies() == ALIEN)
                .reduce(0, (accumulator, charact) -> accumulator + charact.getOrigin().getResidents().size(), Integer::sum);

    }



}
