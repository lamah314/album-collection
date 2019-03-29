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
//	
//	@Test
//	public void testRating() {
//		Album album = new Album("title", "image", "recordLabel");
//		Rating rating = new Rating(1);
//		album.addRatingToAlbum(rating);
//		assertEquals(true, album.checkRatingInAlbum(rating));
//	}
//	
//	@Test 
//	public void testComments() {
//		Album album = new Album("title", "image", "recordLabel");
//		Comment comment = new Comment("new comment");
//		album.addCommentToAlbum(comment);
//		assertEquals(true, album.checkCommentInAlbum(comment));
//	}
//	@Test 
//	public void testTags() {
//		Album album = new Album("title", "image", "recordLabel");
//		Tag tag = new Tag("tag");
//		album.addTagToAlbum(tag);
//		assertEquals(true, album.checkTagInAlbum(tag));
//	}
//
//	
////	@Test 
////	public void testSongs() {
////		Album album = new Album("title", "image", "recordLabel");
////		Song song = new Song("title", "link", "duration");
////		Collection<Song> songList = new ArrayList<Song>();
////		songList.add(song);
////		song.addAlbumToSong(album);
////		assertEquals(true, album.checkSongInAlbum(song));
////	}
////	
//	

}
