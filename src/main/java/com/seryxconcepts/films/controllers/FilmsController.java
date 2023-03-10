package com.seryxconcepts.films.controllers;

import com.seryxconcepts.films.data.models.Film;
import com.seryxconcepts.films.services.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/films")
@AllArgsConstructor
public class FilmsController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public ResponseEntity<List<Film>> allFilms() {
        return new ResponseEntity<>(filmService.getAllFilms(), HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Film>> getFilmBy(@PathVariable String imdbId) {
        return new ResponseEntity<>(filmService.getFilmBy(imdbId), HttpStatus.OK);
    }

}
