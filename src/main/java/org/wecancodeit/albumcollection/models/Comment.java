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
	InputObject inputObject;
	
	
	public Comment() {}

	public Comment(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public Comment(String commentContent, InputObject inputObject) {
		this.commentContent = commentContent;
		this.inputObject = inputObject;

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
