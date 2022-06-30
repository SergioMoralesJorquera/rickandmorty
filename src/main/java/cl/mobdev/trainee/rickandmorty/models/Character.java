package cl.mobdev.trainee.rickandmorty.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Character {

    private int id;

    private String name;

    private String status;

    private String species;

    private String type;

    @JsonPropertyOrder({"id","name","status","species", "type", "episodeCount", "origin"})
    private int episodeCount;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ArrayList episode;
    private Origin origin;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String gender;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Location location;

    //-------------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getEpisodeCount() {
        return episodeCount;
    }
    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }
    public ArrayList getEpisode() {
        return episode;
    }

    public void setEpisode(ArrayList episode) {
        this.episode = episode;
    }
    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }


}
