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

	public Artist() {
	}

	public Artist(String name, String image) {
		super();
		this.name = name;
		this.image = image;
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
