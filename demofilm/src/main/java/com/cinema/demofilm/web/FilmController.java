package com.cinema.demofilm.web;

import com.cinema.demofilm.entities.Film;
import com.cinema.demofilm.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public clasFilmController {
    @Autowired
    FilmService filmService;

    @PostMapping("/add")
    public Film ajouter(@RequestBody Film film){
        return filmService.add(film);
    }

    @GetMapping("/films")
    public List<Film> all(){
        return filmService.getAllFilms();
    }

    @PostMapping("/update/{idfilm}/{id_director}")
    public Film modif(@PathVariable Long idfilm, @PathVariable Long id_director, @RequestBody Film film){
        return filmService.updateFilm(idfilm,id_director,film);
    }

    @DeleteMapping("/deletefilm/{id}")
    public void suppression(@PathVariable Long id){
        filmService.deletFilm(id);
    }

    @GetMapping("/filmsbytitre/{str}")
    public List<Film> rechParTitre(@PathVariable String str){
        return filmService.getFilmsByTitre(str);
    }

}
