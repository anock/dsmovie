package com.dsmovie.dto;

import com.dsmovie.entities.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {

    private Long id;
    private String title;
    private Double score;
    private Integer count;
    private String image;

    public MovieDto(){}

    public MovieDto(Long id, String title, Double score, Integer count, String image) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.count = count;
        this.image = image;
    }

    public MovieDto(Movie movie) {
        id = movie.getId();
        title = movie.getTitle();
        score = movie.getScore();
        count = movie.getCount();
        image = movie.getImage();
    }


}
