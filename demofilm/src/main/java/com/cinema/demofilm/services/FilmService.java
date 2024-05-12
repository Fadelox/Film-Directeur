package com.cinema.demofilm.services;

import com.cinema.demofilm.entities.Film;

import java.util.List;

public interface FilmService {
    Film add(Film film);
    List<Film> getAllFilms();
    Film updateFilm(Long idfilm, long idDirector, Film film);
    void deletFilm(Long id);
    List<Film> getFilmsByTitre(String str);
}
