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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDTO other = (AddressDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
