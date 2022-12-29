package com.myProjects.gameAwards.service.impl;

import com.myProjects.gameAwards.domain.model.Game;
import com.myProjects.gameAwards.domain.repository.GameRepository;
import com.myProjects.gameAwards.service.GameService;
import com.myProjects.gameAwards.service.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> findall() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElseThrow(() -> new NoContentException());
    }

    @Override
    public void create(Game game) {

    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void delete(Game game) {

    }
}
