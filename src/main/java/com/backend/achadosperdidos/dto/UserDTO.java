package com.backend.achadosperdidos.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.backend.achadosperdidos.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "can't be empty")
	@Length(min = 3, max = 80, message = "Length must be between 5 and 80")
	private String name;
	@NotEmpty(message = "can't be empty")
	@Email
	private String email;
	@NotEmpty(message = "can't be empty")
	@Length(min = 8, max = 20, message = "Length must be between 8 and 20")
	private String phone;
	@NotEmpty(message = "can't be empty")
	private String password;
	private String cpf;
	
	private UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String phone, String password, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.cpf = cpf;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.cpf = entity.getCpf();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public User toEntity() {
		return new User(id, name, email, phone, password, cpf);
	}
	
	
}
