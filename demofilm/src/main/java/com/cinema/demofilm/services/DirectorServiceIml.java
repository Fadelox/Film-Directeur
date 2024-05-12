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
public class DirectorServiceIml implements DirectorService {
    @Autowired
    DirectorRepo directorRepo;

    @Autowired
    FilmRepo filmRepo;

    @Override
    public Director add(Director director) {
        return directorRepo.save(director);
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorRepo.findAll();
    }

    @Override
    public Director updateDirector(Long id, Director newDriector) {
        Optional<Director> optionalDirector = directorRepo.findById(id);
        if (optionalDirector.isPresent()) {
            Director director = optionalDirector.get();
            director.setNom(newDriector.getNom());
            director.setPays(newDriector.getPays());
            return directorRepo.save(director);
        }else {
            throw new EntityNotFoundException("Il n'ya pad de Director avec cet ID"+id);
        }
    }

    @Override
    public void deleteDirector(Long id) {
        Optional<Director> optionalDirector = directorRepo.findById(id);
        if(optionalDirector.isPresent()){
            Director director = optionalDirector.get();
            //-----------supp film-------------------
            List<Film> films = filmRepo.findFilmsByDirector(director);
            if (films.size() > 0){
                for(Film film : films){
                    filmRepo.delete(film);
                }
            }

            //--------------------------

            directorRepo.delete(director);
        }else{
            throw new EntityNotFoundException("Director with id="+id+"dosen't exist!");
        }
    }

    @Override
    public List<Director> searchByName(String str) {
        return directorRepo.findDirectorsByNomContaining(str);
    }

}
