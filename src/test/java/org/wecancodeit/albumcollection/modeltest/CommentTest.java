package org.wecancodeit.albumcollection.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Comment;

public class CommentTest {
	@Test
	public void testComment() {
		Comment comment = new Comment("content");
		assertEquals("content", comment.getCommentContent());	
	}

}
