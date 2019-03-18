package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.albumcollection.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

	Rating findByRating(int rating);

}
