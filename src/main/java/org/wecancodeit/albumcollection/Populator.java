package org.wecancodeit.albumcollection;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;

@Service
public class Populator implements CommandLineRunner {


	@Resource
	private ArtistRepository artistRepo;


	@Override
	public void run(String... args) throws Exception {
		Artist artist1 = artistRepo.save(new Artist("Anthony"));
		
		
	}
}
