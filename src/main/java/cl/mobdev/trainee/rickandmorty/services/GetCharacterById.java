package cl.mobdev.trainee.rickandmorty.services;

import cl.mobdev.trainee.rickandmorty.models.Character;

public interface GetCharacterById {
    Character execute(int id);

}
