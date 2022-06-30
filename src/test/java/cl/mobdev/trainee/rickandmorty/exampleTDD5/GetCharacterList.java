package cl.mobdev.trainee.rickandmorty.exampleTDD5;

import cl.mobdev.trainee.rickandmorty.models.Character;
import org.apache.logging.log4j.util.PropertySource;

import java.util.*;



public class GetCharacterList {

    private String MARS = "Mars";
    private CharacterListGateway characterListGateway;

    private Character character;
    private final MartianTranslate martianTranslate;

    public GetCharacterList(CharacterListGateway characterListGateway, MartianTranslate martianTranslate) {
        this.characterListGateway = characterListGateway;
        this.martianTranslate = martianTranslate;
    }

    public ArrayList<Character> execute(){
        ArrayList<Character> listCharacters = characterListGateway.getCharacter();

        if (!listCharacters.isEmpty()){
            listCharacters.stream().forEach((lc)-> {
                if (null !=lc.getOrigin()){
                    if (MARS.equals(lc.getOrigin().getName())){
                        lc.setType(martianTranslate.execute(lc.getName()));
                    }else {
                        lc.setType("");
                    }
                }else {
                    lc.setType("");
                }
            });

            listCharacters.sort((a,b)->a.getName().compareToIgnoreCase(b.getName()));

            //clase collection
            //interfaz comparator
            /*Collections.sort(listCharacters, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });*/

        }

        return listCharacters;
    }

}
