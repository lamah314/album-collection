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
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Comment;
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
	
//	@GetMapping("/addArtist")
//	public ArtistRepository getArtistRepo() {
//		return artistRepo;
//	}
	
	@PostMapping("/addArtist")
	public Collection<Artist> addArtist(@RequestBody String newArtist) throws JSONException{
		JSONObject json = new JSONObject(newArtist);
		artistRepo.save(new Artist(json.getString("name"), json.getString("image")));
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	//Lindsey Comment controller
//	@PostMapping("/addComment")
//	public Collection<Comment> addComment(@RequestBody String newComment) throws JSONException{
//		JSONObject json = new JSONObject(newComment);
//		artistRepo.save(new Comment(json.getString("comments")));
//		return (Collection<Comment>) artistRepo.findAll();
//	}
		
}
