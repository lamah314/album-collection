package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.albumcollection.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

}
