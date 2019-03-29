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
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;
import org.wecancodeit.albumcollection.repositories.TagRepository;


@RestController
@RequestMapping("/artists")
public class ArtistController {
	
	@Resource
	ArtistRepository artistRepo;
	@Resource
	AlbumRepository albumRepo;
	@Resource
	SongRepository songRepo;
	
	@Resource
	TagRepository tagRepo;
	
//	@GetMapping("/")
//	public String getArtistHome() {
//		return "/artists/home";
//	}
	
	@GetMapping("")
	public Collection<Artist> getArtists() {
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	@GetMapping("/{artistId}")
	public Artist getArtist(@PathVariable Long artistId) {
		return artistRepo.findById(artistId).get();
	}
	
	@PostMapping("/addArtist")
	public Collection<Artist> addArtist(@RequestBody String newArtist) throws JSONException{
		JSONObject json = new JSONObject(newArtist);
		artistRepo.save(new Artist(json.getString("name"), json.getString("image")));
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	@PostMapping("/nameToId")
	public Long convertNameToId(@RequestBody String artistName) throws JSONException {
		JSONObject json = new JSONObject(artistName);
		Long artistId = artistRepo.findByName(json.getString("artistName")).getId();
		return artistId;
	}
	
	@PostMapping("/addRatingComment")
	public Artist AddRatingCommentToArtist(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		Rating rating = new Rating(Integer.parseInt(json.getString("rating")));
		Comment comment = new Comment(json.getString("comment"));
		Artist artist = artistRepo.findById(Long.parseLong(json.getString("artistId"))).get();
		artist.addRatingToArtist(rating);
		artist.addCommentToArtist(comment);
		artistRepo.save(artist);
		return artist;
	}
}
