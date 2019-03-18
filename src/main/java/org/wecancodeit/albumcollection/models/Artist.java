package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String imgUrl;
	
	private int age;
		
	private Collection<Album> albums;

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

	public Artist() {}
	
	public Artist(String name, String imgUrl, int age, Album...albums) {
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
	
	public void addSongToArtist(Song song) {
		songs.add(song);
	}
	
	public boolean checkSongInArtist(Song song) {
		return songs.contains(song);
	}
	
}
