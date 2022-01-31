package com.valentin.enfoques_trabajointegrador;

public class Personaje {

    private String nombre_personaje;
    private String nombre_real;
    private String lugar_nacimiento;
    private String editorial;
    private Powerstat powerstat;
    private InformacionPersonal datos;
    private String img;
    private String id;

    public Personaje () {}

    public Personaje(String nombre_personaje, String nombre_real, String lugar_nacimiento, String editorial, Powerstat powerstat, InformacionPersonal datos, String img, String id) {
        this.nombre_personaje = nombre_personaje;
        this.nombre_real = nombre_real;
        this.lugar_nacimiento = lugar_nacimiento;
        this.editorial = editorial;
        this.powerstat = powerstat;
        this.datos = datos;
        this.img = img;
        this.id = id;
    }

    public String getNombre_personaje() {
        return nombre_personaje;
    }

    public String getNombre_real() {
        return nombre_real;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public String getEditorial() {
        return editorial;
    }

    public Powerstat getPowestat() {
        return powerstat;
    }

    public InformacionPersonal getInformacionPersonal() {
        return datos;
    }

    public String getImg() {
        return img;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre_personaje='" + nombre_personaje + '\'' +
                ", nombre_real='" + nombre_real + '\'' +
                ", lugar_nacimiento='" + lugar_nacimiento + '\'' +
                ", editorial='" + editorial + '\'' +
                ", poderes='" + powerstat.toString() + '\'' +
                ", datos='" + datos.toString() + '\'' +
                ", img='" + img + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
