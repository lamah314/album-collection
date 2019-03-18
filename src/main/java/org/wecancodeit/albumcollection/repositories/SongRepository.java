package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.albumcollection.models.Song;

@Repository
public interface SongRepository extends CrudRepository <Song, Long>{

	
	
}




