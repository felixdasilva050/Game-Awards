package com.myProjects.gameAwards.service.impl;

import com.myProjects.gameAwards.domain.model.Game;
import com.myProjects.gameAwards.domain.repository.GameRepository;
import com.myProjects.gameAwards.service.GameService;
import com.myProjects.gameAwards.service.exception.BusinessException;
import com.myProjects.gameAwards.service.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;
    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findAllSortByVoteDESC() {
        return gameRepository.findAll(Sort.by(Sort.Direction.DESC, "vote"));
    }

    @Override
    public Game findById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElseThrow(() -> new NoContentException("Não foi possível localizar o ID informado"));
    }
    @Override
    public void create(Game game) {
        if(Objects.isNull(game.getId())){
            gameRepository.save(game);
        } else {
            Game gameDB = findById(game.getId());
            if (game.getName().equalsIgnoreCase(gameDB.getName())){
                throw new BusinessException("Há um Game com o mesmo nome");
            } else {
                throw new BusinessException("Há um Game com o mesmo ID");
            }
        }
    }
    @Override
    public void update(Game game) {
        final Game GAME_DB= findById(game.getId());
        if(GAME_DB.getId().equals(game.getId())){
            gameRepository.save(game);
        }else{
            throw new BusinessException("Os ID são diferentes");
        }
    }
    @Override
    public void delete(Game game) {
        if(gameRepository.existsById(game.getId())){
            gameRepository.delete(game);
        } else {
            throw new BusinessException("Não foi possível localizar o Game");
        }
    }

    @Override
    public void updateVote(Long id) {
        Game gameDB = findById(id);
        gameDB.setVote(gameDB.getVote()+1);
        update(gameDB);
    }
}
