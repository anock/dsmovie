package com.dsmovie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "tb_score")
public class Score {

    @EmbeddedId
    private ScorePk id = new ScorePk();

    private Double value;

    public Score(){}

    public Score(ScorePk id, Double value) {
        this.id = id;
        this.value = value;
    }

    public void setMovie(Movie movie){
        id.setMovie(movie);
    }
    public void setUser(User user){
        id.setUser(user);
    }

}
