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
	Object entity;
	
	
	public Comment() {}
	
	public Comment(String commentContent, Object entity) {
		this.commentContent = commentContent;
		this.entity = entity;

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
