package org.wecancodeit.albumcollection.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Comment;
import org.wecancodeit.albumcollection.models.Rating;
import org.wecancodeit.albumcollection.models.Tag;

public class ArtistTest {
	@Test
	public void testArtistGetters() {
		Artist artist = new Artist("name", "image");
		assertEquals("name", artist.getName());
		assertEquals("image", artist.getImage());
		
	}
	
	@Test
	public void testAlbum() {
		Album album = new Album("title", "image", "recordLabel");
		Artist artist = new Artist("name", "image");
		artist.addAlbumToArtist(album);
		assertEquals(true, artist.checkAlbumInArtist(album));
	}
	
	@Test 
	public void testComments() {
		Artist artist = new Artist("name", "image");
		Comment comment = new Comment("new comment");
		artist.addCommentToArtist(comment);
		assertEquals(true, artist.checkCommentInArtist(comment));
	}
	@Test
	public void testCalculateRatings() {
		Artist artist = new Artist("name", "image");
		Rating rating = new Rating(5);
		Rating rating2 = new Rating(2);
		artist.addRatingToArtist(rating2);
		artist.addRatingToArtist(rating);
		artist.calculateAvgRating();
		assertEquals(3.5, artist.getAvgRating(), 0.000001);
	}

}
