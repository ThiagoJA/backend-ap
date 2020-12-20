package com.backend.achadosperdidos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.backend.achadosperdidos.entities.Address;
import com.backend.achadosperdidos.entities.Tag;
import com.backend.achadosperdidos.entities.User;
import com.backend.achadosperdidos.repositories.AddressRepository;
import com.backend.achadosperdidos.repositories.TagRepository;
import com.backend.achadosperdidos.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private TagRepository tagRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", "99999993233");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", "99090909090");

		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Tag t1 = new Tag(null, "Celular");
		Tag t2 = new Tag(null, "Carteira");
		Tag t3 = new Tag(null, "Documento");
		Tag t4 = new Tag(null, "Bolsa");
		Tag t5 = new Tag(null, "Chave");
		Tag t6 = new Tag(null, "Relogio");
		Tag t7 = new Tag(null, "Anel");
		
		tagRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7));
		
		Address a1 = new Address(null, 38400000, "Uberlândia", "Carajás", "Rua 1");
		Address a2 = new Address(null, 38414011, "Uberlândia", "Tubalina", "Rua 2");
		Address a3 = new Address(null, 38420044, "Uberlândia", "Santa Monica", "Rua 3");
		
		addressRepository.saveAll(Arrays.asList(a1, a2, a3));
		
	}
}
