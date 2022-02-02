package com.valentin.enfoques_trabajointegrador;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Personaje")
public class Entity_Personaje {


    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "id_personaje")
    String id_personaje;
    @ColumnInfo(name = "nombre_personaje")
    String nombre_personaje;
    @ColumnInfo(name = "nombre_real")
    String nombre_real;
    @ColumnInfo(name = "lugar_nacimiento")
    String lugar_nacimiento;
    @ColumnInfo(name = "editorial")
    String editorial;
    @ColumnInfo(name = "poder_iteligencia")
    String poder_inteligencia;
    @ColumnInfo(name = "poder_fuerza")
    String poder_fuerza;
    @ColumnInfo(name = "poder_velocidad")
    String poder_velocidad;
    @ColumnInfo(name = "poder_durabilidad")
    String poder_durabilidad;
    @ColumnInfo(name = "poder_energia")
    String poder_energia;
    @ColumnInfo(name = "poder_combate")
    String poder_combate;
    @ColumnInfo(name = "dato_genero")
    String dato_genero;
    @ColumnInfo(name = "dato_raza")
    String dato_raza;
    @ColumnInfo(name = "dato_altura")
    String dato_altura;
    @ColumnInfo(name = "dato_peso")
    String dato_peso;
    @ColumnInfo(name = "dato_colorOjos")
    String dato_colorOjos;
    @ColumnInfo(name = "dato_colorPelo")
    String dato_colorPelo;
    @ColumnInfo(name = "dato_ocupacion")
    String dato_ocupacion;
    @ColumnInfo(name = "url_imagen")
    String url_imagen;

    @ColumnInfo(name = "favorito")
    int favorito;

    public Entity_Personaje(String id_personaje, String nombre_personaje, String nombre_real,
                            String lugar_nacimiento, String editorial, String poder_inteligencia, String poder_fuerza,
                            String poder_velocidad, String poder_durabilidad, String poder_energia, String poder_combate,
                            String dato_genero, String dato_raza, String dato_altura, String dato_peso, String dato_colorOjos,
                            String dato_colorPelo, String dato_ocupacion, String url_imagen) {

        this.id_personaje = id_personaje;
        this.nombre_personaje = nombre_personaje;
        this.nombre_real = nombre_real;
        this.lugar_nacimiento = lugar_nacimiento;
        this.editorial = editorial;
        this.poder_inteligencia = poder_inteligencia;
        this.poder_fuerza = poder_fuerza;
        this.poder_velocidad = poder_velocidad;
        this.poder_durabilidad = poder_durabilidad;
        this.poder_energia = poder_energia;
        this.poder_combate = poder_combate;
        this.dato_genero = dato_genero;
        this.dato_raza = dato_raza;
        this.dato_altura = dato_altura;
        this.dato_peso = dato_peso;
        this.dato_colorOjos = dato_colorOjos;
        this.dato_colorPelo = dato_colorPelo;
        this.dato_ocupacion = dato_ocupacion;
        this.url_imagen = url_imagen;
        this.favorito = 1;
    }

    public String getId_personaje() {
        return id_personaje;
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

    public String getPoder_inteligencia() {
        return poder_inteligencia;
    }

    public String getPoder_fuerza() {
        return poder_fuerza;
    }

    public String getPoder_velocidad() {
        return poder_velocidad;
    }

    public String getPoder_durabilidad() {
        return poder_durabilidad;
    }

    public String getPoder_energia() {
        return poder_energia;
    }

    public String getPoder_combate() {
        return poder_combate;
    }

    public String getDato_genero() {
        return dato_genero;
    }

    public String getDato_raza() {
        return dato_raza;
    }

    public String getDato_altura() {
        return dato_altura;
    }

    public String getDato_peso() {
        return dato_peso;
    }

    public String getDato_colorOjos() {
        return dato_colorOjos;
    }

    public String getDato_colorPelo() {
        return dato_colorPelo;
    }

    public String getDato_ocupacion() {
        return dato_ocupacion;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public int getFavorito() {
        return favorito;
    }

    @Override
    public String toString() {
        return "Entity_Personaje{" +
                "id=" + id +
                ", id_personaje='" + id_personaje + '\'' +
                ", nombre_personaje='" + nombre_personaje + '\'' +
                ", nombre_real='" + nombre_real + '\'' +
                ", lugar_nacimiento='" + lugar_nacimiento + '\'' +
                ", editorial='" + editorial + '\'' +
                ", poder_inteligencia='" + poder_inteligencia + '\'' +
                ", poder_fuerza='" + poder_fuerza + '\'' +
                ", poder_velocidad='" + poder_velocidad + '\'' +
                ", poder_durabilidad='" + poder_durabilidad + '\'' +
                ", poder_energia='" + poder_energia + '\'' +
                ", poder_combate='" + poder_combate + '\'' +
                ", dato_genero='" + dato_genero + '\'' +
                ", dato_raza='" + dato_raza + '\'' +
                ", dato_altura='" + dato_altura + '\'' +
                ", dato_peso='" + dato_peso + '\'' +
                ", dato_colorOjos='" + dato_colorOjos + '\'' +
                ", dato_colorPelo='" + dato_colorPelo + '\'' +
                ", dato_ocupacion='" + dato_ocupacion + '\'' +
                ", url_imagen='" + url_imagen + '\'' +
                ", favorito=" + favorito +
                '}';
    }
}
