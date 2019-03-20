package org.wecancodeit.albumcollection.models;



import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class Comment {
	
	private String commentContent;

	public Comment() {}

	public Comment(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String getCommentContent() {
		return commentContent;
	}

	@Override
	public String toString() {
		return "Comment [commentContent=" + commentContent + "]";
	}
	
}
