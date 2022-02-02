package com.valentin.enfoques_trabajointegrador;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entity_Personaje.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    @SuppressWarnings("WeakerAcces")
    public abstract PersonajeDAO personajeDAO();

    private static AppDataBase aInstance;
}
