package cl.mobdev.trainee.rickandmorty.gateway;

import cl.mobdev.trainee.rickandmorty.models.Character;

public interface GetEndpointRootGateway {
    Character execute(int id);
}
