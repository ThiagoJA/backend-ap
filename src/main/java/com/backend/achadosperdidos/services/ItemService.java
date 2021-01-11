package com.backend.achadosperdidos.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.achadosperdidos.dto.ItemDTO;
import com.backend.achadosperdidos.dto.ItemInsertDTO;
import com.backend.achadosperdidos.entities.Item;
import com.backend.achadosperdidos.repositories.ItemRepository;
import com.backend.achadosperdidos.resources.exeptions.DatabaseException;
import com.backend.achadosperdidos.resources.exeptions.ResourceNotFoundException;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	public Page<ItemDTO> findAllPaged(Pageable pageable) {
		Page<Item> list =  repository.findAll(pageable);
		return list.map(e -> new ItemDTO(e));
	}
	
	public ItemDTO findById(Long id) {
		Optional<Item> obj = repository.findById(id);
		Item entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ItemDTO(entity);
	}
	
	public ItemDTO insert(ItemInsertDTO dto) {
		Item entity = dto.toEntity();
		entity = repository.save(entity);
		return new ItemDTO(entity);
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
	public ItemDTO update(Long id, ItemDTO dto) {
		try {
			Item entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new ItemDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Item entity, ItemDTO dto) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setReward(dto.getReward());
		
	}

}