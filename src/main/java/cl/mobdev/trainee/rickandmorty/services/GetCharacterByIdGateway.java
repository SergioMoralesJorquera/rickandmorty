package cl.mobdev.trainee.rickandmorty.services;

import cl.mobdev.trainee.rickandmorty.models.Character;

public interface GetCharacterByIdGateway {
    Character execute(int id);

}
