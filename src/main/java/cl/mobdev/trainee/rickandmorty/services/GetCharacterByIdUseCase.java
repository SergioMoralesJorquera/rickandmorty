package cl.mobdev.trainee.rickandmorty.services;
import cl.mobdev.trainee.rickandmorty.gateway.GetEndPointOriginGateway;
import cl.mobdev.trainee.rickandmorty.gateway.GetEndpointRootGateway;
import cl.mobdev.trainee.rickandmorty.models.Character;
import cl.mobdev.trainee.rickandmorty.models.Origin;
import org.springframework.stereotype.Service;

@Service
public class GetCharacterByIdUseCase implements GetCharacterById {

    private final GetEndpointRootGateway getEndpointRootGateway;
    private final GetEndPointOriginGateway getEndPointOriginGateway;

    public GetCharacterByIdUseCase(GetEndpointRootGateway getEndpointRootGateway, GetEndPointOriginGateway getEndPointOriginGateway) {
        this.getEndpointRootGateway = getEndpointRootGateway;
        this.getEndPointOriginGateway = getEndPointOriginGateway;
    }

    @Override
    public Character execute(int id){

        //obtiene datos desde la API para el objeto Root
        Character character = this.getEndpointRootGateway.execute(id);

        //seteo de los episodios para obtener su valor numerico
        character.setEpisodeCount(character.getEpisode().size());

        //obtiene datos del endpoint estructurado en el objeto origin, siempre y cuando
        //exista la url
        if (character.getOrigin().getUrl()!=""){
            character.setOrigin(this.getEndPointOriginGateway.execute(character.getOrigin().getUrl()));
        }
        else {
            character.setOrigin(new Origin());
        }

        return character;

    }

}
