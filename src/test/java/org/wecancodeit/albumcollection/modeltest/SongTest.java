package org.wecancodeit.albumcollection.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Rating;
import org.wecancodeit.albumcollection.models.Song;


public class SongTest {
	@Test
	public void testSongGetters() {
		Song song = new Song("title", "link", "duration");
		assertEquals("title", song.getTitle());
		assertEquals("link", song.getLink());
		assertEquals("duration", song.getDuration());	
	}
	@Test
	public void testArtist() {
		Song song = new Song("title", "link", "duration");
		Artist artist = new Artist("name", "image");
		song.addArtistToSong(artist);
		assertEquals(artist, song.getArtist());
		assertEquals(true, song.checkArtistInSong(artist));
	}
	@Test
	public void testAlbum() {
		Song song = new Song("title", "link", "duration");
		Album album = new Album("title", "image", "recordLabel");
		song.addAlbumToSong(album);
		assertEquals(album, song.getAlbum());
		assertEquals(true, song.checkAlbumInSong(album));
	}
	@Test
	public void testCalculateRatings() {
		Song song = new Song("title", "link", "duration");
		Rating rating = new Rating(5);
		Rating rating2 = new Rating(2);
		song.addRatingToSong(rating2);
		song.addRatingToSong(rating);
		song.calculateAvgRating();
		assertEquals(3.5, song.getAvgRating(), 0.000001);
	}

}
