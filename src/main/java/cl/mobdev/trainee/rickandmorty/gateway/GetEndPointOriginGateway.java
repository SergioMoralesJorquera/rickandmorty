package cl.mobdev.trainee.rickandmorty.gateway;

import cl.mobdev.trainee.rickandmorty.models.Origin;

public interface GetEndPointOriginGateway {
    Origin execute(String url);
}
