package com.seryxconcepts.films.data.repositories;

import com.seryxconcepts.films.data.models.Film;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FilmRepository extends MongoRepository<Film, ObjectId> {
    Optional<Film> findByImdbId(String imdbId);
}
