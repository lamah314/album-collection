package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;
import org.wecancodeit.albumcollection.repositories.TagRepository;

@RestController
@RequestMapping("/songs")
public class SongController {

	@Resource
	ArtistRepository artistRepo;
	@Resource
	AlbumRepository albumRepo;
	@Resource
	SongRepository songRepo;
	
	@Resource
	TagRepository tagRepo;

//	@GetMapping("/")
//	public String getSongHome() {
//		return "/songs/home";
//	}
	
	@GetMapping("")
	public Collection<Song> getSongs() {
		return (Collection<Song>) songRepo.findAll();
	}
	
	@PostMapping("/addSong")
	public Collection<Artist> addSong(@RequestBody String body) throws JSONException{
		JSONObject json = new JSONObject(body);
		Song song = songRepo.save(new Song(json.getString("title"), json.getString("link"), json.getString("duration")));
		Album album = albumRepo.findById(Long.parseLong(json.getString("album"))).get();
		Artist artist = album.getArtist();
		song.addArtistToSong(artist);
		song.addAlbumToSong(album);
		songRepo.save(song);
		return (Collection<Artist>) artistRepo.findAll();
	}

}
