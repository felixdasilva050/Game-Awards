package com.myProjects.gameAwards.controller;

import com.myProjects.gameAwards.domain.model.Game;
import com.myProjects.gameAwards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController extends BaseRestController {
    @Autowired
    private GameService businessLayer;

    @GetMapping("games/findAll")
    public ResponseEntity<List<Game>> findAll(){
        List<Game> games = businessLayer.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("games/findAll/byVoteDESC")
    public ResponseEntity<List<Game>> findAllVoteDESC(){
        List<Game> games = businessLayer.findAllSortByVoteDESC();
        return ResponseEntity.ok(games);
    }

    @GetMapping("game/findBy/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        Game game = businessLayer.findById(id);
        return ResponseEntity.ok(game);
    }
    @PostMapping("game/create")
    public  ResponseEntity<Game> create(@RequestBody Game game){
        businessLayer.create(game);
        return ResponseEntity.ok(game);
    }
    @PutMapping("game/update/{id}")
    public  ResponseEntity<Game> update(@RequestBody Game game, @PathVariable Long id){
        businessLayer.update(game);
        return ResponseEntity.ok(game);
    }
    @DeleteMapping("game/delete/{id}")
    public  ResponseEntity<Game> delete(@RequestBody Game game, @PathVariable Long id){
        businessLayer.delete(game);
        return ResponseEntity.ok(game);
    }

    @PatchMapping("game/{id}/vote")
    public ResponseEntity<Game> updateVote(@PathVariable Long id){
        businessLayer.updateVote(id);
        return ResponseEntity.ok().build();
    }

}
