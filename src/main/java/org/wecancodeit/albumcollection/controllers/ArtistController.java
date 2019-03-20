package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Artist;
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
	
	@GetMapping("/addArtist")
	public ArtistRepository getArtistRepo() {
		return artistRepo;
	}
	
	@PostMapping("/addArtist")
	public void addArtist(Artist artist) {
		artistRepo.save(new Artist("Red", "Red img"));
	}
		
}
