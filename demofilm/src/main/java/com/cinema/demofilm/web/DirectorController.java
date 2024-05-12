package com.cinema.demofilm.web;

import com.cinema.demofilm.entities.Director;
import com.cinema.demofilm.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/director")
public class DirectorController {
    @Autowired
    DirectorService directorService;

    @PostMapping("/add")
    public Director ajouter(@RequestBody Director director){
        return directorService.add(director);
    }
    //----------------------------------
    @PostMapping("/update/{id}")
    public Director modification(@PathVariable Long id, @RequestBody Director director){
        return directorService.updateDirector(id,director);
    }
    //-------------------------------------
    @DeleteMapping("/delete/{id}")
    public void suppression(@PathVariable Long id){
        directorService.deleteDirector(id);
    }
    //---------------------------------
    @GetMapping("/findbyname/{str}")
    public List<Director> recherchParNom(@PathVariable String str){
        return directorService.searchByName(str);
    }
}
