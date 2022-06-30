package cl.mobdev.trainee.rickandmorty.exampleTDD1;
import cl.mobdev.trainee.rickandmorty.models.Character;

public class IsCharacterFromEarth {
    private String planetEarth="Earth";
    public boolean execute(Character character){
        return planetEarth.equals(character.getOrigin().getName()) ? true: false;

    }
}
