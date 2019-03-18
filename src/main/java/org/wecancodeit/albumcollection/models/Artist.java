package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="artists")
	private Collection<Post> posts;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	public Artist() {}
	
	public Artist(String name) {
		this.name = name;
	}
	
	public Artist(String name, Post ...posts) {
		this.name = name;
		this.posts = Arrays.asList(posts);
	}
	
	public void addPostToAuthor(Post post) {
		posts.add(post);
	}
	
	public boolean checkPostsInAuthor(Post post) {
		return posts.contains(post);
	}
	
}
