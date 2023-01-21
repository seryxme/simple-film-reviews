package com.seryxconcepts.films.data.repositories;

import com.seryxconcepts.films.data.models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
