package org.wecancodeit.albumcollection.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id 
	@GeneratedValue
	private Long id;
	private String commentContent;

	
	@ManyToOne	
	Album album;
	
	
	public Comment() {}

	public Comment(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public Comment(String commentContent, Album album) {
		this.commentContent = commentContent;
		this.album = album;

	}

	public Long getId() {
		return id;
	}

	public String getCommentContent() {
		return commentContent;
	}


	@Override
	public String toString() {
		return "Comment [commentContent=" + commentContent + "]";
	}
	
}
