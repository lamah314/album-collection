package org.wecancodeit.albumcollection.modeltest;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Comment;
import org.wecancodeit.albumcollection.models.Rating;
import org.wecancodeit.albumcollection.models.Tag;

public class AlbumTest {

	@Test
	public void testAlbumGetters() {
		Album album = new Album("title", "image", "recordLabel");
		assertEquals("title", album.getTitle());
		assertEquals("image", album.getImage());
		assertEquals("recordLabel", album.getRecordLabel());
	}

	@Test
	public void testArtist() {
		Album album = new Album("title", "image", "recordLabel");
		Artist artist = new Artist("name", "image");
		album.addArtistToAlbum(artist);
		assertEquals(artist, album.getArtist());
		assertEquals(true, album.checkArtistInAlbum(artist));
	}

	@Test
	public void testRating() {
		Album album = new Album("title", "image", "recordLabel");
		Rating rating = new Rating(1);
		album.addRatingToAlbum(rating);
		assertEquals(true, album.checkRatingInAlbum(rating));
	}

	@Test
	public void testComments() {
		Album album = new Album("title", "image", "recordLabel");
		Comment comment = new Comment("new comment");
		album.addCommentToAlbum(comment);
		assertEquals(true, album.checkCommentInAlbum(comment));
	}

	@Test
	public void testTags() {
		Album album = new Album("title", "image", "recordLabel");
		Tag tag = new Tag("tag");
		album.addTagToAlbum(tag);
		assertEquals(true, album.checkTagInAlbum(tag));
	}

	@Test
	public void testCalculateRatings() {
		Album album = new Album("title", "image", "recordLabel");
		Rating rating = new Rating(5);
		Rating rating2 = new Rating(2);
		album.addRatingToAlbum(rating2);
		album.addRatingToAlbum(rating);
		album.calculateAvgRating();
		assertEquals(3.5, album.getAvgRating(), 0.000001);
	}

}
