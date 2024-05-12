package com.cinema.demofilm.repositories;

import com.cinema.demofilm.entities.Director;
import com.cinema.demofilm.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film,Long> {
    List<Film> findFilmsByDirector(Director director);
    List<Film> findFilmsByTitreContaining(String str);
    List<Film> findFilmsByCategorieContaining(String str);

}
