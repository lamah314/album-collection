package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album{

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
	@JsonIgnore
	private Collection<Artist> artists;

	@ElementCollection
	@CollectionTable
	private Collection<Rating> albumRatings;

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
		this.artists = new ArrayList<Artist>();
		this.songs = new ArrayList<Song>();
		this.albumRatings = new ArrayList<Rating>();
		this.albumComments = new ArrayList<Comment>();
		this.tags = new ArrayList<Tag>();
	}
	
//	public Album(String title, String image, String recordLabel, Artist...artists) {
//		this.title = title;
//		this.image = image;
//		this.recordLabel = recordLabel;
//		this.artists = Arrays.asList(artists);
//		this.albumRatings = new ArrayList<Rating>();
//		this.albumComments = new ArrayList<Comment>();
//		this.tags = new ArrayList<Tag>();
//	}
//	
//	public Album(String title, String image, String recordLabel, Song...songs) {
//		this.title = title;
//		this.image = image;
//		this.recordLabel = recordLabel;
//		this.songs = Arrays.asList(songs);
//		this.albumRatings = new ArrayList<Rating>();
//		this.albumComments = new ArrayList<Comment>();
//		this.tags = new ArrayList<Tag>();
//	}
//	
//	public Album(String title, String image, String recordLabel, Artist artist, Rating rating,
//			Comment comment, Tag tag) {
//		this.title = title;
//		this.image = image;
//		this.recordLabel = recordLabel;
//		this.artists = Arrays.asList(artist);
//		this.albumRatings = Arrays.asList(rating);
//		this.albumComments = Arrays.asList(comment);
//		this.tags = Arrays.asList(tag);
//	}
//	
//	public Album(String title, String image, String recordLabel, Song song, Artist artist) {
//		this.title = title;
//		this.image = image;
//		this.recordLabel = recordLabel;
//		this.songs = Arrays.asList(song);
//		this.artists = Arrays.asList(artist);
//		this.albumRatings = new ArrayList<Rating>();
//		this.albumComments = new ArrayList<Comment>();
//		this.tags = new ArrayList<Tag>();
//	}

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
	
	public Collection<Artist> getArtists() {
		return artists;
	}
	
	public void addSongToAlbum(Song song) {
		songs.add(song);
	}
	
	public void addArtistToAlbum(Artist artist) {
		artists.add(artist);
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
		return artists.contains(artist);
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

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", image=" + image + ", recordLabel=" + recordLabel + ", songs="
				+ songs + ", artists=" + artists + ", ratings=" + albumRatings + ", comments=" + albumComments + ", tags=" + tags
				+ "]";
	}


}
