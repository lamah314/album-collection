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
	InputObject inputObject;

	public Rating() {
	}

	public Rating(int rating) {
		this.rating = rating;
	}
	
	public Rating(int rating, InputObject inputObject) {
		this.rating = rating;
		this.inputObject = inputObject;
	}

	public int getRating() {
		return rating;
	}

	public Object getInputObject() {
		return inputObject;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", inputObject=" + inputObject + "]";
	}


}