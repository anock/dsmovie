package com.dsmovie.services;

import com.dsmovie.dto.MovieDto;
import com.dsmovie.entities.Movie;
import com.dsmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<MovieDto> findALl(Pageable pageable){
       Page<Movie> result = repository.findAll(pageable);
        Page<MovieDto> page = result.map(x -> new MovieDto(x));
        return page;
    }
    @Transactional(readOnly = true)
    public MovieDto findById(Long id){
        Movie result = repository.findById(id).get();
        MovieDto dto = new MovieDto(result);
        return dto;
    }
}
