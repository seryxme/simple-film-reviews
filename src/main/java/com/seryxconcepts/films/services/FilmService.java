package com.seryxconcepts.films.services;

import com.seryxconcepts.films.data.models.Film;
import com.seryxconcepts.films.data.repositories.FilmRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmBy(String imdbId) {
        return filmRepository.findByImdbId(imdbId);
    }
}
