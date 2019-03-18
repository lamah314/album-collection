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
	Object entity;

	public Rating() {
	}

	public Rating(int rating) {
		this.rating = rating;
	}
	
	public Rating(int rating, Object entity) {
		this.rating = rating;
		this.entity = entity;
	}

	public int getRating() {
		return rating;
	}

	public Object getEntity() {
		return entity;
	}

	@Override
	public String toString() {
		return "Rating [rating=" + rating + ", entity=" + entity + "]";
	}

}