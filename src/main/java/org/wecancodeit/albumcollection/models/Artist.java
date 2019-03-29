package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist{

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String image;

	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums;

	@OneToMany(mappedBy = "artist")
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
		this.albums = new ArrayList<Album>();
		this.songs = new ArrayList<Song>();
		this.artistRatings = new ArrayList<Rating>();
		this.artistComments = new ArrayList<Comment>();
	}

	public void addAlbumToArtist(Album album) {
		albums.add(album);
	}
	//Should this be  to Artist not album???
	public void addCommentToAlbum(Comment comment) {
		artistComments.add(comment);
	}
	
	public boolean checkAlbumInArtist(Album album) {
		return albums.contains(album);
	}
	//Should this be changed to Artist
	public boolean checkCommentInAlbum(Comment comment) {
		return artistComments.contains(comment);
	}
	
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", image=" + image + ", albums=" + albums
				+ ", songs=" + songs + "]";
	}

}
