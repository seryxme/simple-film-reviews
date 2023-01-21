package com.seryxconcepts.films.services;

import com.seryxconcepts.films.data.models.Film;
import com.seryxconcepts.films.data.models.Review;
import com.seryxconcepts.films.data.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review newReview = new Review();
        newReview.setBody(reviewBody);
        Review savedReview = reviewRepository.save(newReview);

        mongoTemplate.update(Film.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(savedReview))
                .first();

        return savedReview;
    }
}
