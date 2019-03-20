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
public class Song{

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String link;
	private String duration;

	@ManyToMany
	@JoinTable(name = "song_artist", joinColumns = { @JoinColumn(name = "song") }, inverseJoinColumns = {
			@JoinColumn(name = "artist") })
	@JsonIgnore
	private Collection<Artist> artists;

	@ManyToMany
	@JoinTable(name = "song_album", joinColumns = { @JoinColumn(name = "song") }, inverseJoinColumns = {
			@JoinColumn(name = "album") })
	@JsonIgnore
	private Collection<Album> albums;
	
	@ElementCollection
	@CollectionTable
	private Collection<Rating> songRatings;

	@ElementCollection
	@CollectionTable
	private Collection<Comment> songComments;

	public Song() {
	}

	public Song(String title, String link, String duration) {
		this.title = title;
		this.link = link;
		this.duration = duration;
	}

	public Song(String title, String link, String duration, Artist artist, Album album) {
		this.title = title;
		this.link = link;
		this.duration = duration;
		this.artists = Arrays.asList(artist);
		this.albums = Arrays.asList(album);
	}
	
	public Song(String title, String link, String duration, Artist artist, Album album, Rating rating,
			Comment comment) {
		this.title = title;
		this.link = link;
		this.duration = duration;
		this.artists = Arrays.asList(artist);
		this.albums = Arrays.asList(album);
		this.songRatings = Arrays.asList(rating);
		this.songComments = Arrays.asList(comment);
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

	public Collection<Rating> getSongRatings() {
		return songRatings;
	}

	public Collection<Comment> getSongComments() {
		return songComments;
	}

	public void addArtistToSong(Artist artist) {
		artists.add(artist);
	}
	
	public void addAlbumToSong(Album album) {
		albums.add(album);
	}
	
	public void addRatingToAlbum(Rating rating) {
		songRatings.add(rating);
	}

	public void addCommentToAlbum(Comment comment) {
		songComments.add(comment);
	}
	
	public boolean checkArtistInSong(Artist artist) {
		return artists.contains(artist);
	}
	
	public boolean checkAlbumInSong(Album album) {
		return albums.contains(album);
	}

	public boolean checkRatingInAlbum(Rating rating) {
		return songRatings.contains(rating);
	}
	
	public boolean checkCommentInAlbum(Comment comment) {
		return songComments.contains(comment);
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", link=" + link + ", duration=" + duration + ", artists="
				+ artists + ", albums=" + albums + "]";
	}

}
