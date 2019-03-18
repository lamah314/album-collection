package org.wecancodeit.albumcollection.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;


@RestController
@RequestMapping("/artists")
public class ArtistController {
	
	@Resource
	ArtistRepository artistRepo;
	@Resource
	AlbumRepository albumRepo;
	@Resource
	SongRepository songRepo;
	
	@GetMapping("/")
	public String getArtistHome() {
		return "/artists/home";
	}
	
	
}
