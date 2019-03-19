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
public class Artist extends InputObject{

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String image;

	@ManyToMany(mappedBy = "artists")
	private Collection<Album> albums;

	@ManyToMany(mappedBy = "artists")
	private Collection<Song> songs;

	@OneToMany(mappedBy = "inputObject")
	private Collection<Rating> ratings;

	@OneToMany(mappedBy = "inputObject")
	private Collection<Comment> comments;

	@ManyToMany(mappedBy = "inputObjects")
	private Collection<Tag> tags;

	public Long getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public Collection<Album> getAlbums() {
		return albums;
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

	public Artist() {
	}

	public Artist(String name, String image) {
		this.name = name;
		this.image = image;
	}
	
	public Artist(String name, String image, Album album, Song song, Rating rating, Comment comment, Tag tag) {
		this.name = name;
		this.image = image;
		this.albums = Arrays.asList(album);
		this.songs = Arrays.asList(song);
		this.ratings = Arrays.asList(rating);
		this.comments = Arrays.asList(comment);
		this.tags = Arrays.asList(tag);
	}

	public void addAlbumToArtist(Album album) {
		albums.add(album);
	}

	public boolean checkAlbumInArtist(Album album) {
		return albums.contains(album);
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", image=" + image + ", albums=" + albums
				+ ", songs=" + songs + "]";
	}

}
