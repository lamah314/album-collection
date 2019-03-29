package org.wecancodeit.albumcollection.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.wecancodeit.albumcollection.models.Rating;


public class RatingTest {
	
	@Test
	public void testRating() {
		Rating rating = new Rating(2);
		assertEquals(2, rating.getRating());	
	}

}
