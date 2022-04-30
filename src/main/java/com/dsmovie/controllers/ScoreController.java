package com.dsmovie.controllers;
import com.dsmovie.dto.MovieDto;
import com.dsmovie.dto.ScoreDto;
import com.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService service;

    @Autowired
    public ScoreController(ScoreService service) {
        this.service = service;
    }

    @PutMapping
    public MovieDto saveScore(@RequestBody ScoreDto dto){
        MovieDto movieDto = service.saveScore(dto);
        return movieDto;
    }
}
