package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {

	@Id
	@GeneratedValue
	private Long id;

	private int rating;

	@ManyToOne	
	Album album;

	public Rating() {
	}

	public Rating(int rating) {
		this.rating = rating;
	}
	
	public Rating(int rating, Album album) {
		this.rating = rating;
		this.album = album;
	}

	public int getRating() {
		return rating;
	}

	public Object getAlbum() {
		return album;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", album=" + album + "]";
	}


}