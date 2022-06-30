package cl.mobdev.trainee.rickandmorty.mocks;

import cl.mobdev.trainee.rickandmorty.models.Character;

public class MockCharacter {

    public static Character getCharacterStatus(){
        Character character = new Character();
        character.setName("Morty");
        return character;
    }

}
