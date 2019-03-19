package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.CommentRepository;
import org.wecancodeit.albumcollection.repositories.RatingRepository;
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
	RatingRepository ratingRepo;
	@Resource
	CommentRepository commentRepo;
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

}
