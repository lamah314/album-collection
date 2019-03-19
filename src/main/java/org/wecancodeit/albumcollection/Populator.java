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
		Comment comment2 = commentRepo.save(new Comment("Sucks"));
		Comment comment3 = commentRepo.save(new Comment("Epic"));
		
		Tag tag1 = tagRepo.save(new Tag("Cool"));
		
		Artist artist1 = artistRepo.save(new Artist("Nirvana","nirvanaBand img"));
		Album album1 = albumRepo.save(new Album("Nevermind", "albumNevermind.img", "DGC", artist1, rating1, comment3, tag1));
		Song song1 = songRepo.save(new Song("Lithium", "https://www.youtube.com/watch?v=pkcJEvMcnEg", "4:16", artist1, album1));	
		Song song2 = songRepo.save(new Song("Heart Shaped Box", "https://www.youtube.com/watch?v=n6P0SitRwy8", "4:45", artist1, album1));	
		
		Artist artist2 = artistRepo.save(new Artist("Nine Inch Nails","NineInchNails img"));
		Album album2 = albumRepo.save(new Album("Pretty Hate Machine", "albumPrettyHateMachine.img", "TVT", artist2, rating1, comment3, tag1));
		Song song3 = songRepo.save(new Song("Down In It", "https://www.youtube.com/watch?v=NkphW38WyYo", "4:37", artist2, album2));	
		Song song4 = songRepo.save(new Song("Head Like A Hole", "https://www.youtube.com/watch?v=nOVW938sr0k", "5:00", artist2, album2));
		
		Artist artist3 = artistRepo.save(new Artist("Sublime","Sublime img"));
		Album album3 = albumRepo.save(new Album("Sublime", "albumSublime.img", "MCA", artist3, rating1, comment3, tag1));
		Song song5 = songRepo.save(new Song("Santeria", "https://www.youtube.com/watch?v=k3ZeUL4fRyko", "3:04", artist3, album3));	
		Song song6 = songRepo.save(new Song("What I got", "https://www.youtube.com/watch?v=0Uc3ZrmhDN4", "2:53", artist3, album3));
	}
}
