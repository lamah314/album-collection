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
//	@Test
//	public void testRating() {
//		Song song = new Song("title", "link", "duration");
//		Rating rating = new Rating(3);
//		song.addRatingToSong(rating);
//		assertEquals(3, song.getSongRatings());
//		assertEquals(true, song.checkRatingInSong(rating));
//	}
	

}
