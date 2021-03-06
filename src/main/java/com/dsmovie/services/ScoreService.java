package com.dsmovie.services;

import com.dsmovie.dto.MovieDto;
import com.dsmovie.dto.ScoreDto;
import com.dsmovie.entities.Movie;
import com.dsmovie.entities.Score;
import com.dsmovie.entities.User;
import com.dsmovie.repository.MovieRepository;
import com.dsmovie.repository.ScoreRepository;
import com.dsmovie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDto saveScore(ScoreDto dto){

        User user = userRepository.finByEmail(dto.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);
        double sum = 0.0;
        for(Score s: movie.getScores()){
            sum = sum + s.getValue();
        }
        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDto(movie);

    }



}
