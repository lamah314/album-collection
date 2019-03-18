package org.wecancodeit.albumcollection.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String image;

	private String recordLabel;

	@ManyToMany(mappedBy = "albums")
	private Collection<Song> songs;

	@ManyToMany
	@JoinTable(name = "album_artist", joinColumns = { @JoinColumn(name = "album") }, inverseJoinColumns = {
			@JoinColumn(name = "artist") })
	private Collection<Artist> artists;

	@OneToMany(mappedBy = "entity")
	private Collection<Rating> ratings;

	@OneToMany(mappedBy = "entity")
	private Collection<Comment> comments;

	@ManyToMany(mappedBy = "entities")
	private Collection<Tag> tags;

	public Album() {
	}

	public Album(String title, String image, String recordLabel) {
		super();
		this.title = title;
		this.image = image;
		this.recordLabel = recordLabel;
	}
	
	public Album(String title, String image, String recordLabel, Song song, Artist artist, Rating rating,
			Comment comment, Tag tag) {
		super();
		this.title = title;
		this.image = image;
		this.recordLabel = recordLabel;
		this.songs = Arrays.asList(song);
		this.artists = Arrays.asList(artist);
		this.ratings = Arrays.asList(rating);
		this.comments = Arrays.asList(comment);
		this.tags = Arrays.asList(tag);
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

	public Collection<Song> getSongs() {
		return songs;
	}

	public Collection<Rating> getRatings() {
		return ratings;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", image=" + image + ", recordLabel=" + recordLabel + ", songs="
				+ songs + ", artists=" + artists + "]";
	}

}
