package com.backend.achadosperdidos.dto;

import java.io.Serializable;
import java.time.Instant;

import com.backend.achadosperdidos.entities.Item;

public class ItemInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	private String description;
	private Instant date;
//	private int object_flag; todo -- enum
	private int reward;
	
	public ItemInsertDTO() {
	}
	

	public ItemInsertDTO(Long id, String name, String description, Instant date, int reward) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.reward = reward;
	}


	public ItemInsertDTO(Item entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.date = entity.getDate();
		this.reward = entity.getReward();
	}

	
	public Item toEntity() {
		return new Item(id, name, description, date, reward);
	}
}
