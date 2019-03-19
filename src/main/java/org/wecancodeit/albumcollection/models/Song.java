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
public class Song extends InputObject{

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String link;
	private String duration;

	@ManyToMany
	@JoinTable(name = "song_artist", joinColumns = { @JoinColumn(name = "song") }, inverseJoinColumns = {
			@JoinColumn(name = "artist") })
	private Collection<Artist> artists;

	@ManyToMany
	@JoinTable(name = "song_album", joinColumns = { @JoinColumn(name = "song") }, inverseJoinColumns = {
			@JoinColumn(name = "album") })
	private Collection<Album> albums;

	@OneToMany(mappedBy = "inputObject")
	private Collection<Rating> ratings;

	@OneToMany(mappedBy = "inputObject")
	private Collection<Comment> comments;

	@ManyToMany(mappedBy = "inputObjects")
	private Collection<Tag> tags;

	public Song() {
	}

	public Song(String title, String link, String duration) {
		this.title = title;
		this.link = link;
		this.duration = duration;
	}
	
	public Song(String title, String link, String duration, Artist artist, Album album, Rating rating, Comment comment,
			Tag tag) {
		this.title = title;
		this.link = link;
		this.duration = duration;
		this.artists = Arrays.asList(artist);
		this.albums = Arrays.asList(album);
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

	public String getLink() {
		return link;
	}

	public String getDuration() {
		return duration;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public Collection<Album> getAlbums() {
		return albums;
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
		return "Song [id=" + id + ", title=" + title + ", link=" + link + ", duration=" + duration + ", artists="
				+ artists + ", albums=" + albums + "]";
	}


}
