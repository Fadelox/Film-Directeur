package com.cinema.demofilm.services;

import com.cinema.demofilm.entities.Director;
import com.cinema.demofilm.entities.Film;
import com.cinema.demofilm.repositories.DirectorRepo;
import com.cinema.demofilm.repositories.FilmRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    FilmRepo filmRepo;
    @Autowired
    DirectorRepo directorRepo;
    @Override
    public Film add(Film film) {
        return filmRepo.save(film);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }

    @Override
    public Film updateFilm(Long idfilm, long idDirector, Film film) {
        Optional<Film> optionalFilm = filmRepo.findById(idfilm);
        Optional<Director> optionalDirector = directorRepo.findById(idDirector);
        if(optionalDirector.isPresent() && optionalFilm.isPresent()){
            Film updatedFilm = optionalFilm.get();
            Director director = optionalDirector.get();
            updatedFilm.setTitre(film.getTitre());
            updatedFilm.setCategorie(film.getCategorie());
            updatedFilm.setDuree(film.getDuree());
            updatedFilm.setDirector(director);
            return filmRepo.save(updatedFilm);
        }else {
            throw new EntityNotFoundException("Film ou Director n'exist pas");
        }

    }

    @Override
    public void deletFilm(Long id) {
        Optional<Film> optionalFilm = filmRepo.findById(id);
        if (optionalFilm.isPresent()){
            Film film = optionalFilm.get();
            filmRepo.delete(film);
        }else{
            throw new EntityNotFoundException(" Film n'exist pas id="+id);
        }
    }

    @Override
    public List<Film> getFilmsByTitre(String str) {
        return filmRepo.findFilmsByTitreContaining(str);
    }

}
