package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.albumcollection.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{

}
