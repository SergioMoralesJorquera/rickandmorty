package cl.mobdev.trainee.rickandmorty.exampleTDD3;


import cl.mobdev.trainee.rickandmorty.models.Character;

public class IsFemaleCharacter{

    private String characterType="female";

    private final FemaleCharacterGateway femaleCharacterGateway;

    public IsFemaleCharacter(FemaleCharacterGateway femaleCharacterGateway) {
        this.femaleCharacterGateway = femaleCharacterGateway;
    }

    public Character execute(int id)  {
        Character character = this.femaleCharacterGateway.getId(id);
        String gender = this.femaleCharacterGateway.getId(id).getGender();

        if (characterType.equals(gender)) {
            return character;
        }

        throw new GenderException("El character no es mujer");


    }
}
