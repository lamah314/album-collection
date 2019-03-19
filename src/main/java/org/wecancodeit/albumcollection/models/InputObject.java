package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InputObject{

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}
	
	public InputObject() {}
}
