package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Song {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String link;
	private String duration;
	
	
	public Song() {};
	
	public Song(String title, String link, String duration) {
		this.title = title;
		this.link = link;
		this.duration = duration;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", link=" + link + ", duration=" + duration + "]";
	}
	
	

	
	
	}
	
	
	
	
	
	

	
	

