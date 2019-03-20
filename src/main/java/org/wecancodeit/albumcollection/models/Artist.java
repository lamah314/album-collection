package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artist{

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String image;

	@ManyToMany(mappedBy = "artists")
	private Collection<Album> albums;

	@ManyToMany(mappedBy = "artists")
	private Collection<Song> songs;
	
	@ElementCollection
	@CollectionTable
	private Collection<Rating> artistRatings;

	@ElementCollection
	@CollectionTable
	private Collection<Comment> artistComments;

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
	
	public Collection<Rating> getArtistRatings() {
		return artistRatings;
	}

	public Collection<Comment> getArtistComments() {
		return artistComments;
	}

	public Artist() {
	}

	public Artist(String name, String image) {
		this.name = name;
		this.image = image;
	}
	
	public Artist(String name, String image, Rating rating,
			Comment comment) {
		this.name = name;
		this.image = image;
		this.artistRatings = Arrays.asList(rating);
		this.artistComments = Arrays.asList(comment);
	}

	public void addAlbumToArtist(Album album) {
		albums.add(album);
	}

	public void addRatingToAlbum(Rating rating) {
		artistRatings.add(rating);
	}

	public void addCommentToAlbum(Comment comment) {
		artistComments.add(comment);
	}
	
	public boolean checkAlbumInArtist(Album album) {
		return albums.contains(album);
	}

	public boolean checkRatingInAlbum(Rating rating) {
		return artistRatings.contains(rating);
	}
	
	public boolean checkCommentInAlbum(Comment comment) {
		return artistComments.contains(comment);
	}
	
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", image=" + image + ", albums=" + albums
				+ ", songs=" + songs + "]";
	}

}
