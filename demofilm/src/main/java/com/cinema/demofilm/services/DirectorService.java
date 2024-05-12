package com.cinema.demofilm.services;

import com.cinema.demofilm.entities.Director;

import java.util.List;

public interface DirectorService {
    Director add(Director director);
    List<Director> getAllDirectors();
    Director updateDirector(Long id, Director newDriector);
    void deleteDirector(Long id);
    List<Director> searchByName(String str);

}
