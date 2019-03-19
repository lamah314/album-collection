package org.wecancodeit.albumcollection.models;

import java.util.Arrays;
import java.util.Collection;

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

	@ManyToMany
	@JoinTable(name = "tag_inputObject", joinColumns = { @JoinColumn(name = "tag") }, inverseJoinColumns = {
			@JoinColumn(name = "inputObject") })
	private Collection<InputObject> inputObjects;

	public Tag() {
	}

	public Tag(String tag) {
		this.tag = tag;
	}
	
	public Tag(String tag, InputObject...inputObjects) {
		this.tag = tag;
		this.inputObjects = Arrays.asList(inputObjects);
	}

	public String getTag() {
		return tag;
	}

	public Collection<InputObject> getInputObject() {
		return inputObjects;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tag=" + tag + ", inputObjects=" + inputObjects + "]";
	}


}
