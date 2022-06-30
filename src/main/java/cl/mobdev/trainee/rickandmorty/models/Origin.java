package cl.mobdev.trainee.rickandmorty.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Origin {

    private String name;
    private String url;
    private String dimension;
    private ArrayList residents;

    //reescribiendo constructor para setear sus atributos"";
    public Origin(){
        this.name="";
        this.url="";
        this.dimension="";
        this.residents= new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public ArrayList getResidents() {
        return residents;
    }

    public void setResidents(ArrayList residents) {
        this.residents = residents;
    }
}
