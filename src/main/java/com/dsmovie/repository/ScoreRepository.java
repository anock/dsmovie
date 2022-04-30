package com.dsmovie.repository;

import com.dsmovie.entities.Movie;
import com.dsmovie.entities.Score;
import com.dsmovie.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}
