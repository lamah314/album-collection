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
	public Collection<Artist> addAlbum(@RequestBody String newAlbum) throws JSONException{
		JSONObject json = new JSONObject(newAlbum);
		Artist artist = artistRepo.findById(Long.parseLong(json.getString("artist"))).get();
		Album album = new Album(json.getString("title"), json.getString("image"), json.getString("recordLabel"));
		album.addArtistToAlbum(artist);
		albumRepo.save(album);
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	@PostMapping("/nameToId")
	public String convertNameToId(@RequestBody String albumTitle) {
		Long albumId = albumRepo.findByTitle(albumTitle).getId();
		return Long.toString(albumId);
	}
	
	@GetMapping("/{albumid}")
	public Album getAlbum(@PathVariable Long albumid) {
		return albumRepo.findById(albumid).get();			
	}
}
