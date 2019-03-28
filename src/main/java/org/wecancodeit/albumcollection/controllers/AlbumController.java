package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Comment;
import org.wecancodeit.albumcollection.models.Rating;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;
import org.wecancodeit.albumcollection.repositories.TagRepository;

@RestController
@RequestMapping("/albums")
public class AlbumController {

	@Resource
	ArtistRepository artistRepo;
	@Resource
	AlbumRepository albumRepo;
	@Resource
	SongRepository songRepo;
	
	@Resource
	TagRepository tagRepo;
	
//	@GetMapping("/")
//	public String getAlbums() {
//		return "/albums/home";
//	}
	
	@GetMapping("")
	public Collection<Album> getAlbums() {
		return (Collection<Album>) albumRepo.findAll();
	}
	
	@PostMapping("/addAlbum")
	public Collection<Album> addAlbum(@RequestBody String newAlbum) throws JSONException{
		JSONObject json = new JSONObject(newAlbum);
		Artist artist = artistRepo.findById(Long.parseLong(json.getString("artist"))).get();
		Album album = new Album(json.getString("title"), json.getString("image"), json.getString("recordLabel"));
		album.addArtistToAlbum(artist);
		albumRepo.save(album);
		return (Collection<Album>) albumRepo.findAll();
	}
	
	@PostMapping("/addAlbumSpecific")
	public Artist addAlbumSpecific(@RequestBody String newAlbum) throws JSONException{
		JSONObject json = new JSONObject(newAlbum);
		Artist artist = artistRepo.findById(Long.parseLong(json.getString("artist"))).get();
		Album album = new Album(json.getString("title"), json.getString("image"), json.getString("recordLabel"));
		album.addArtistToAlbum(artist);
		albumRepo.save(album);
		return artist;
	}
	
	@PostMapping("/nameToId")
	public Long convertNameToId(@RequestBody String albumTitle) throws JSONException {
		JSONObject json = new JSONObject(albumTitle);
		Long albumId = albumRepo.findByTitle(json.getString("albumTitle")).getId();
		return albumId;
	}
	
	@GetMapping("/{albumId}")
	public Album getAlbum(@PathVariable Long albumId) {
		return albumRepo.findById(albumId).get();			
	}
	
	@PostMapping("/addRatingComment")
	public Album AddRatingCommentToAlbum(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		Rating rating = new Rating(Integer.parseInt(json.getString("rating")));
		Comment comment = new Comment(json.getString("comment"));
		Album album = albumRepo.findById(Long.parseLong(json.getString("albumId"))).get();
		album.addRatingToAlbum(rating);
		album.addCommentToAlbum(comment);
		albumRepo.save(album);
		return album;
	}
}
