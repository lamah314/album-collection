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
	
	private double avgRating;

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
	
	public double getAvgRating() {
		return avgRating;
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
		calculateAvgRating();
	}

	public void addAlbumToArtist(Album album) {
		albums.add(album);
	}

  public void addRatingToArtist(Rating rating) {
		artistRatings.add(rating);
		calculateAvgRating();
	}
	
	public void addCommentToArtist(Comment comment) {
		artistComments.add(comment);
	}
	
	public boolean checkAlbumInArtist(Album album) {
		return albums.contains(album);
	}
	
	public boolean checkCommentInArtist(Comment comment) {
		return artistComments.contains(comment);
	}
	
	public void calculateAvgRating() {
		double count=0;
		double sum =0;
		for (Rating rating : artistRatings) {
			sum += rating.getRating();
			count++;
		}
		if (count > 0) {
			avgRating = sum/count;
		}
	}

}
