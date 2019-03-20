package org.wecancodeit.albumcollection.models;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class Rating {

	private int rating;

	public Rating() {
	}

	public Rating(int rating) {
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Rating [rating=" + rating + "]";
	}


}