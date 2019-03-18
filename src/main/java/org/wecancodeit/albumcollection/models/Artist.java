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
public class Artist {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String imgUrl;

	private int age;

	@ManyToMany(mappedBy = "artists")
	private Collection<Album> albums;

	@ManyToMany(mappedBy = "artists")
	private Collection<Song> songs;

	@OneToMany(mappedBy = "entity")
	private Collection<Rating> ratings;

	@OneToMany(mappedBy = "entity")
	private Collection<Comment> comments;

	@ManyToMany(mappedBy = "artists")
	private Collection<Tag> tags;

	public Long getId() {
		return id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
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

	public Artist(String name, String imgUrl, int age, Album... albums) {
		this.name = name;
		this.imgUrl = imgUrl;
		this.age = age;
		this.albums = Arrays.asList(albums);
	}

	public void addAlbumToArtist(Album album) {
		albums.add(album);
	}

	public boolean checkAlbumInArtist(Album album) {
		return albums.contains(album);
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", imgUrl=" + imgUrl + ", age=" + age + ", albums=" + albums
				+ ", songs=" + songs + "]";
	}

}
