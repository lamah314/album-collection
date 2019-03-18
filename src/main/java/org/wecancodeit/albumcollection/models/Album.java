package org.wecancodeit.albumcollection.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	@ManyToMany(mappedBy="songs")
	public Collection<Song> getSongs() {
		return songs;
	}
	
	private String image;
	
	private Collection<Song> songs;
	
	private String recordLabel;
	
	public Album () {}

	public Album(String title, String image, Collection<Song> songs, String recordLabel) {
		super();
		this.title = title;
		this.image = image;
		this.songs = songs;
		this.recordLabel = recordLabel;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}
	
	
	public String getRecordLabel() {
		return recordLabel;
	}
	
	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", image=" + image + ", recordLabel=" + recordLabel + "]";
	}
	
}
