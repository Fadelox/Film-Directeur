package com.cinema.demofilm;


import com.cinema.demofilm.entities.Film;
import com.cinema.demofilm.repositories.FilmRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemofilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemofilmApplication.class, args);
    }
    /*@Bean
    CommandLineRunner commandLineRunner(FilmRepo filmRepo){
        return args -> {
            Film film = new Film(null,"Don't Look up","SCI-FICT",180);
            filmRepo.save(film);
            List<Film> films = filmRepo.findAll();
            for(Film f:films){
                System.out.println(f.getTitre());
            }
        };
    }*/


}
