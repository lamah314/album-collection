package org.wecancodeit.albumcollection.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.repositories.SongRepository;




	@RestController
	@RequestMapping("/songs")
	public class SongController {
		
		@Resource
		SongRepository songRepo;
		
		@GetMapping("/")
		public String getSongHome() {
			return "/songs/home";
		}
		
		
	}
