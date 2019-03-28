package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album{

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String image;

	private String recordLabel;

	@OneToMany(mappedBy = "album")
	private Collection<Song> songs;

	@ManyToOne
	@JsonIgnore
	private Artist artist;

	@ElementCollection
	@CollectionTable
	private Collection<Rating> albumRatings;

	private int avgRating;
	
	@ElementCollection
	@CollectionTable
	private Collection<Comment> albumComments;

	@ManyToMany
//	@JoinTable(name = "album_tag", joinColumns = { @JoinColumn(name = "album") }, inverseJoinColumns = {
//			@JoinColumn(name = "tag") })
	private Collection<Tag> tags;

	public Album() {
	}

	public Album(String title, String image, String recordLabel) {
		this.title = title;
		this.image = image;
		this.recordLabel = recordLabel;
		this.songs = new ArrayList<Song>();
		this.albumRatings = new ArrayList<Rating>();
		this.albumComments = new ArrayList<Comment>();
		this.tags = new ArrayList<Tag>();
		calculateAvgRating();
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
	
	public Artist getArtist() {
		return artist;
	}
	
	public Collection<Rating> getAlbumRatings() {
		return albumRatings;
	}
	
	public int getAvgRating() {
		return avgRating;
	}

	public Collection<Comment> getAlbumComments() {
		return albumComments;
	}
	

	
	public void addArtistToAlbum(Artist artist) {
		this.artist = artist;
	}
	
	public void addRatingToAlbum(Rating rating) {
		albumRatings.add(rating);
	}

	public void addCommentToAlbum(Comment comment) {
		albumComments.add(comment);
	}
	
	public void addTagToAlbum(Tag tag) {
		tags.add(tag);
	}
	
	public boolean checkSongInAlbum(Song song) {
		return songs.contains(song);
	}
	
	public boolean checkArtistInAlbum(Artist artist) {
		return this.artist.equals(artist);
	}
	
	public boolean checkRatingInAlbum(Rating rating) {
		return albumRatings.contains(rating);
	}
	
	public boolean checkCommentInAlbum(Comment comment) {
		return albumComments.contains(comment);
	}
	
	public boolean checkTagInAlbum(Tag tag) {
		return tags.contains(tag);
	}

	public void calculateAvgRating() {
		int count=0;
		int sum =0;
		for (Rating rating : albumRatings) {
			sum += rating.getRating();
			count++;
		}
		if (count > 0) {
			avgRating = sum/count;
		}
	}
	
}
