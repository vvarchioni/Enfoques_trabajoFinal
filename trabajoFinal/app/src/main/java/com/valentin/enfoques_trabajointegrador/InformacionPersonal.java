package com.valentin.enfoques_trabajointegrador;

public class InformacionPersonal {

    private String gender;
    private String race;
    private String height;
    private String weight;
    private String eyesColor;
    private String hairColor;
    private String occupation;

    public InformacionPersonal(String gender, String race, String height, String weight, String eyesColor, String hairColor, String occupation) {
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weight = weight;
        this.eyesColor = eyesColor;
        this.hairColor = hairColor;
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getOccupation() {
        return occupation;
    }
}
