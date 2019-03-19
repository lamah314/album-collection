package org.wecancodeit.albumcollection;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Comment;
import org.wecancodeit.albumcollection.models.Rating;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.models.Tag;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.CommentRepository;
import org.wecancodeit.albumcollection.repositories.RatingRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;
import org.wecancodeit.albumcollection.repositories.TagRepository;

@Service
public class Populator implements CommandLineRunner {

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


	@Override
	public void run(String... args) throws Exception {
		
		Rating rating1 = ratingRepo.save(new Rating(5));
		
		Comment comment1 = commentRepo.save(new Comment("Great"));
		
		Tag tag1 = tagRepo.save(new Tag("Cool"));
		
		Artist artist1 = artistRepo.save(new Artist("Anthony","MyFace.jpg"));
		
		Album album1 = albumRepo.save(new Album("Circle", "Square", "Triangle", artist1, rating1, comment1, tag1));

		Song song1 = songRepo.save(new Song("Singing", "LINK", "duration", artist1, album1));	
	}
}
