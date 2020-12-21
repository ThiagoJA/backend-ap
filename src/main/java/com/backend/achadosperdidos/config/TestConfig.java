package com.backend.achadosperdidos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.backend.achadosperdidos.entities.Address;
import com.backend.achadosperdidos.entities.Item;
import com.backend.achadosperdidos.entities.Tag;
import com.backend.achadosperdidos.entities.User;
import com.backend.achadosperdidos.repositories.AddressRepository;
import com.backend.achadosperdidos.repositories.ItemRepository;
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
	
	@Autowired
	private ItemRepository itemRepository;

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
		
		
		Item i1 = new Item(null, "Celular", "Moto g com a tela trincada", Instant.parse("2020-07-30T15:21:22Z"), 0);
		Item i2 = new Item(null, "Carteira", "Carteira dobra azul", Instant.parse("2020-02-17T15:21:22Z"), 0);
		Item i3 = new Item(null, "Documento", "RG numero 99999999", Instant.parse("2020-01-30T15:21:22Z"), 0);
		Item i4 = new Item(null, "Bolsa", "Mochila preta encontrada na rua", Instant.parse("2020-04-30T15:21:22Z"), 0);
		Item i5 = new Item(null, "Chave", "Chave de fusca", Instant.parse("2020-04-30T15:21:22Z"), 0);
		Item i6 = new Item(null, "Relogio", "Relógio triton", Instant.parse("2020-02-17T15:21:22Z"), 0);
		Item i7 = new Item(null, "Anel", "Aliança de ouro", Instant.parse("2020-01-30T15:21:22Z"), 0);
		
		i1.getTags().add(t1);
		i2.getTags().add(t2);
		i3.getTags().add(t3);
		i4.getTags().add(t4);
		i5.getTags().add(t5);
		i6.getTags().add(t6);
		i7.getTags().add(t7);
		
		itemRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7));
		
		
	}
}
