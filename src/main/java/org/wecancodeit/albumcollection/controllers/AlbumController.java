package org.wecancodeit.albumcollection.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;

@RestController
@RequestMapping("/albums")
public class AlbumController {

	@Resource
	AlbumRepository albumRepo;
	
	@GetMapping("/")
	public String getAlbums() {
		return "/albums/home";
	}
}
