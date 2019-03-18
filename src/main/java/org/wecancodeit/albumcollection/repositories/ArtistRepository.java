package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.albumcollection.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

	Artist findByName(String name);

}
