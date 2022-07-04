package cl.mobdev.trainee.rickandmorty.controller;
import cl.mobdev.trainee.rickandmorty.models.Character;
import cl.mobdev.trainee.rickandmorty.services.GetCharacterByIdGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/character")
public class Controller {

    //inyectar la interfaz por medio de construcrtor de la clase
    private final GetCharacterByIdGateway getCharacterByIdGateway;

    public Controller(GetCharacterByIdGateway getCharacterByIdGateway) {
        this.getCharacterByIdGateway = getCharacterByIdGateway;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Character> getCharactersForId(@PathVariable int id) {
        return ResponseEntity.ok(getCharacterByIdGateway.execute(id));//envuelve la respuesta como si fuera un 200
    }
}
