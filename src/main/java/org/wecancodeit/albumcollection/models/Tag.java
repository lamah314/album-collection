package org.wecancodeit.albumcollection.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.assertj.core.util.Arrays;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	private String tag;

	@ManyToMany
	@JoinTable(name = "tag_entity", joinColumns = { @JoinColumn(name = "tag") }, inverseJoinColumns = {
			@JoinColumn(name = "entity") })
	private Collection<Object> entities;

	public Tag() {
	}

	public Tag(String tag) {
		this.tag = tag;
	}
	
	public Tag(String tag, Object...entities) {
		this.tag = tag;
		this.entities = Arrays.asList(entities);
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
