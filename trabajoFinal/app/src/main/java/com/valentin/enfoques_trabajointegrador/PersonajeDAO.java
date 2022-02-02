package com.valentin.enfoques_trabajointegrador;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonajeDAO {

    @Query("SELECT * FROM personaje")
    List<Entity_Personaje> getAll();

    @Query("SELECT * FROM personaje WHERE favorito = 1")
    List<Entity_Personaje> getMyFavorites();

    @Query("DELETE FROM personaje WHERE id_personaje = :id_personaje")
    void delete(String id_personaje);

    @Query("SELECT * FROM personaje WHERE id_personaje = :id_personaje")
    Entity_Personaje exist(String id_personaje);

    @Insert
    Long insert(Entity_Personaje personaje);



}
