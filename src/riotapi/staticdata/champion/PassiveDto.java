package riotapi.staticdata.champion;

import riotapi.staticdata.image.ImageDto;

public class PassiveDto {
    private String description;
    private ImageDto image;
    private String name;
    private String sanitizedDescription;

    public String get_description(){
        return description;
    }
    public void set_description(String description){
        this.description = description;
    }
    public ImageDto get_image(){
        return image;
    }
    public void set_image(ImageDto image){
        this.image = image;
    }
    public String get_name(){
        return name;
    }
    public void set_name(String name){
        this.name = name;
    }
    public String get_sanitizedDescription(){
        return sanitizedDescription;
    }
    public void set_sanitizedDescription(String sanitizedDescription){
        this.sanitizedDescription = sanitizedDescription;
    }
}