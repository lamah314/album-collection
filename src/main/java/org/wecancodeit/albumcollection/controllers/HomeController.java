package org.wecancodeit.albumcollection.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.CommentRepository;
import org.wecancodeit.albumcollection.repositories.RatingRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;
import org.wecancodeit.albumcollection.repositories.TagRepository;

@Controller
public class HomeController {

	@Resource
	ArtistRepository artistRepo;
	@Resource
	AlbumRepository albumRepo;
	@Resource
	SongRepository songRepo;
	
	@Resource
	RatingRepository ratingRepo;
	@Resource
	CommentRepository commentRepo;
	@Resource
	TagRepository tagRepo;
	
	
//		@GetMapping("/")
		public String Home() {
			return "index";
		}
}
