package com.backend.achadosperdidos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.backend.achadosperdidos.dto.AddressDTO;
import com.backend.achadosperdidos.dto.AddressInsertDTO;
import com.backend.achadosperdidos.entities.Address;
import com.backend.achadosperdidos.repositories.AddressRepository;
import com.backend.achadosperdidos.resources.exeptions.DatabaseException;
import com.backend.achadosperdidos.resources.exeptions.ResourceNotFoundException;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	public List<AddressDTO> findAll() {
		List<Address> list = repository.findAll();
		return list.stream().map(e -> new AddressDTO(e)).collect(Collectors.toList());
	}
	
	public AddressDTO findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		Address entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new AddressDTO(entity);
	}
	
	public AddressDTO insert(AddressInsertDTO dto) {
		Address entity = dto.toEntity();
		entity = repository.save(entity);
		return new AddressDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
	
	@Transactional
	public AddressDTO update(Long id, AddressDTO dto) {
		try {
			Address entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new AddressDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Address entity, AddressDTO dto) {
		entity.setStreet(dto.getStreet());
		entity.setDistrict(dto.getDistrict());
		entity.setCity(dto.getCity());
	}

}