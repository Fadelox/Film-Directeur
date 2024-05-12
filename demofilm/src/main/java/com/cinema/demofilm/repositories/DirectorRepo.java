package com.cinema.demofilm.repositories;

import com.cinema.demofilm.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepo extends JpaRepository<Director,Long> {
    List<Director> findDirectorsByNomContaining(String str);
    List<Director> findDirectorsByPaysContaining(String str);
}
