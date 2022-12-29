package com.myProjects.gameAwards.service;

import com.myProjects.gameAwards.domain.model.Game;

import java.util.List;

public interface GameService  {

    List<Game> findall();
    Game findById(Long id);
    void create(Game game);
    void update(Game game);
    void delete(Game game);
}
