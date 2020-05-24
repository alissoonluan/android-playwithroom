package com.example.playwithroom.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.playwithroom.model.PlayGame;

import java.util.List;

@Dao
public interface PlayGameDao {

    @Insert
    public void insert(PlayGame game);

    @Query("SELECT * FROM PlayGame")
    List<PlayGame> getAllGames();

    @Query("SELECT * FROM PlayGame WHERE id= :id")
    PlayGame getById(int id);

    @Query("DELETE FROM PlayGame WHERE id=:id")
    void delete(int id);
}
