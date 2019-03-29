package org.wecancodeit.albumcollection.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	private String tag;

	@ManyToMany(mappedBy= "tags")
	private Collection<Album> albums;

	public Tag() {
	}

	public Tag(String tag) {
		this.tag = tag;
	}

	public Tag(String tag, Album... albums) {
		this.tag = tag;
		this.albums = Arrays.asList(albums);
	}

	public String getTag() {
		return tag;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public void addAlbumtoTag(Album album) {
		albums.add(album);
	}

	public boolean checkAlbumInTag(Album album) {
		return albums.contains(album);
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tag=" + tag + ", albums=" + albums + "]";
	}

}
