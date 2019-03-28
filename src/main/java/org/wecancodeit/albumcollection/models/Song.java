package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song{

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String link;
	private String duration;

	@ManyToOne
	@JsonIgnore
	private Artist artist;

	@ManyToOne
	@JsonIgnore
	private Album album;
	
	@ElementCollection
	@CollectionTable
	private Collection<Rating> songRatings;
	
	private int avgRating;

	@ElementCollection
	@CollectionTable
	private Collection<Comment> songComments;

	public Song() {
	}

	public Song(String title, String link, String duration) {
		this.title = title;
		this.link = link;
		this.duration = duration;
		this.songRatings = new ArrayList<Rating>();
		this.songComments = new ArrayList<Comment>();
		calculateAvgRating();
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

	public Artist getArtist() {
		return artist;
	}

	public Album getAlbum() {
		return album;
	}

	public Collection<Rating> getSongRatings() {
		return songRatings;
	}
	
	public int getAvgRating() {
		return avgRating;
	}

	public Collection<Comment> getSongComments() {
		return songComments;
	}

	public void addArtistToSong(Artist artist) {
		this.artist = artist;
	}
	
	public void addAlbumToSong(Album album) {
		this.album = album;
	}
	
	public void addRatingToSong(Rating rating) {
		songRatings.add(rating);
	}

	public void addCommentToSong(Comment comment) {
		songComments.add(comment);
	}
	
	public boolean checkArtistInSong(Artist artist) {
		return this.artist.equals(artist);
	}
	
	public boolean checkAlbumInSong(Album album) {
		return this.album.equals(album);
	}

	public boolean checkRatingInAlbum(Rating rating) {
		return songRatings.contains(rating);
	}
	
	public boolean checkCommentInAlbum(Comment comment) {
		return songComments.contains(comment);
	}

	public void calculateAvgRating() {
		int count=0;
		int sum =0;
		for (Rating rating : songRatings) {
			sum += rating.getRating();
			count++;
		}
		if (count > 0) {
			avgRating = sum/count;
		}
	}
	
}
