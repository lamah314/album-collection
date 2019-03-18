package org.wecancodeit.albumcollection.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Resource
	ArtistRepository artistRepo;
	@Resource
	AlbumRepository albumRepo;
	@Resource
	SongRepository songRepo;
	
		@GetMapping("/")
		public String getHome() {
			return "index";
		}
}
