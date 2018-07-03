package com.yangz.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.yangz.pokemon.data.PokemonRegistry;
import com.yangz.pokemon.datatype.PokemonTemplate;

public class PokemonJava8Test {
	
	static public void main(String[] args) {
		/*
		List<PokemonTemplate> ret = 
		PokemonRegistry.pokemons.stream().filter(p -> Arrays.stream(p.getMove1()).parallel().anyMatch(q -> "ICE".equalsIgnoreCase(q))).collect(Collectors.toList());
		
//		ret.stream().forEach(p -> System.out.println(p.getName()));
		ret.stream().map(p -> p.getName()).collect(Collectors.toList()).stream().forEach(System.out::println);
		*/
	}

}
