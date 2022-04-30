package com.dsmovie.controllers;

import com.dsmovie.dto.MovieDto;
import com.dsmovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public Page<MovieDto> findAll(Pageable pageable){
        return service.findALl(pageable);
    }
    @GetMapping("/{id}")
    public MovieDto finById(@PathVariable Long id){
        return service.findById(id);
    }
}
