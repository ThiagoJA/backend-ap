package com.backend.achadosperdidos.dto;

import java.io.Serializable;

import com.backend.achadosperdidos.entities.Address;

public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int postalCode;
	private String city;
	private String district;
	private String street;
	
	private AddressDTO() {
	}

	public AddressDTO(Long id, int postalCode, String city, String district, String street) {
		super();
		this.id = id;
		this.postalCode = postalCode;
		this.city = city;
		this.district = district;
		this.street = street;
	}



	public AddressDTO(Address entity) {
		this.id = entity.getId();
		this.postalCode = entity.getPostalCode();
		this.city = entity.getCity();
		this.district = entity.getDistrict();
		this.street = entity.getStreet();
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Address toEntity() {
		return new Address(id, postalCode, city, district, street);
	}
	
}
