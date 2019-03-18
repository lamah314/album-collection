package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.albumcollection.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

		Album findByTitle(String title);
}
