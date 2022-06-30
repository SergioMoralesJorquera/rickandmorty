package cl.mobdev.trainee.rickandmorty.exampleTDD2;

import cl.mobdev.trainee.rickandmorty.models.Character;

public class IsHuman {

    private String specieHuman = "Human";

    //inyecto inbterfaz por constructor
    private final CharacterGateway characterGateway;
    public IsHuman(CharacterGateway characterGateway) {

        this.characterGateway = characterGateway;
    }

    public boolean execute(int id){
        //por medio de mockito, el this.characterGateway........ hace referencia al mismo objeto character seteado a human en el test
        //Character character = this.characterGateway.getId(id);
        //condicional
        if ((specieHuman).equals(this.characterGateway.getId(id).getSpecies())){
            return true;
        }

        return false;
    }
}
