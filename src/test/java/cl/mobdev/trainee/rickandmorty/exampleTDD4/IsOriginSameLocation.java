package cl.mobdev.trainee.rickandmorty.exampleTDD4;


import cl.mobdev.trainee.rickandmorty.models.Character;

public class IsOriginSameLocation {

    private String characterUnknown = "unknown";

    public boolean execute(Character character) {

        String originName = character.getOrigin().getName();
        String locationName = character.getLocation().getName();

        if (characterUnknown.equals(originName) && characterUnknown.equals(locationName)) {
            throw new LocationException("unknown location and origin");
        } else {
            if (characterUnknown.equals(originName)) {
                throw new LocationException("unknown origin");
            }

            else if (characterUnknown.equals(locationName)) {
                throw new LocationException("unknown location");
            }

            else if (originName.equals(locationName)) {
                return true;
            }

            return false;
        }

    }


}
