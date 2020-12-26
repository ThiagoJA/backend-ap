package com.backend.achadosperdidos.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.backend.achadosperdidos.entities.Item;
import com.backend.achadosperdidos.entities.Tag;

public class TagDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	
	private TagDTO() {
	}

	public TagDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public TagDTO(Tag entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Tag toEntity() {
		return new Tag(id, name);
	}
	
}
