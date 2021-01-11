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

import com.backend.achadosperdidos.dto.TagDTO;
import com.backend.achadosperdidos.dto.TagInsertDTO;
import com.backend.achadosperdidos.entities.Tag;
import com.backend.achadosperdidos.repositories.TagRepository;
import com.backend.achadosperdidos.resources.exeptions.DatabaseException;
import com.backend.achadosperdidos.resources.exeptions.ResourceNotFoundException;

@Service
public class TagService {
	
	@Autowired
	private TagRepository repository;
	
	public List<TagDTO> findAll() {
		List<Tag> list = repository.findAll();
		return list.stream().map(e -> new TagDTO(e)).collect(Collectors.toList());
	}
	
	public TagDTO findById(Long id) {
		Optional<Tag> obj = repository.findById(id);
		Tag entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new TagDTO(entity);
	}
	
	public TagDTO insert(TagInsertDTO dto) {
		Tag entity = dto.toEntity();
		entity = repository.save(entity);
		return new TagDTO(entity);
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
	public TagDTO update(Long id, TagDTO dto) {
		try {
			Tag entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new TagDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Tag entity, TagDTO dto) {
		entity.setName(dto.getName());
	}

}