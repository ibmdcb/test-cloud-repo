package com.yangz.pokemon.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.yangz.pokemon.datatype.Pokemon;
import com.yangz.pokemon.datatype.PokemonTemplate;

public class PokemonRegistry {
	
	public static ArrayList<PokemonTemplate> pokemons;
	public static HashMap<String, PokemonTemplate> pokemonTemplatesMap;
	
	static {
		pokemons = new ArrayList<PokemonTemplate>();
		
		
		pokemons.add(new PokemonTemplate("Slaking", 4548, 273, "NORMAL", null, 
				new String[]{"NORMAL"},new String[]{"NORMAL", "GROUND", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Groudon", 4548, 273, "GROUND", null, 
				new String[]{"GROUND", "DRAGON"},new String[]{"GROUND", "FIRE", "GRASS"}));
		
		pokemons.add(new PokemonTemplate("Kyogre", 4548, 273, "WATER", null, 
				new String[]{"WATER"},new String[]{"ICE", "ELECTRIC", "WATER"}));
		
		pokemons.add(new PokemonTemplate("Mewtwo", 3982, 193, "PSYCHIC", null, 
				new String[]{"PSYCHIC"},new String[]{"NORMAL", "FIGHTING", "PSYCHIC", "GHOST"}));
		
		pokemons.add(new PokemonTemplate("Ho-Oh", 3889, 193, "FIRE", "FLYING", 
				new String[]{"PSYCHIC", "STEEL"},new String[]{"FIRE", "GRASS", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Tyranitar", 3670, 200, "ROCK", "DARK", 
				new String[]{"DARK", "STEEL", "ROCK"},new String[]{"ROCK", "FIRE", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Rayquaza", 3670, 200, "DRAGON", "FLYING", 
				new String[]{"DRAGON", "FLYING"},new String[]{"ROCK", "DRAGON", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Latios", 3670, 200, "DRAGON", "PSYCHIC", 
				new String[]{"DRAGON", "PSYCHIC"},new String[]{"DRAGON", "PSYCHIC", "GRASS"}));
		
		pokemons.add(new PokemonTemplate("Metagross", 3637, 160, "STEEL", "PSYCHIC", 
				new String[]{"PSYCHIC", "STEEL"},new String[]{"PSYCHIC", "STEEL", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Lugia", 3598, 212, "PSYCHIC", "FLYING", 
				new String[]{"DRAGON", "PSYCHIC"},new String[]{"WATER", "PSYCHIC", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Dragonite", 3530, 154, "DRAGON", "FLYING", 
				new String[]{"DRAGON", "STEEL"},new String[]{"NORMAL", "FLYING", "DRAGON"}));

		pokemons.add(new PokemonTemplate("Salamence", 3530, 154, "DRAGON", "FLYING", 
				new String[]{"DRAGON", "FIRE"},new String[]{"FIRE", "WATER", "DRAGON"}));

		pokemons.add(new PokemonTemplate("Entei", 3377, 230, "FIRE", null, 
				new String[]{"FIRE"},new String[]{"FIRE"}));

		pokemons.add(new PokemonTemplate("Latias", 3670, 200, "DRAGON", "PSYCHIC", 
				new String[]{"DRAGON", "PSYCHIC"},new String[]{"DRAGON", "PSYCHIC", "ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Snorlax", 3307, 262, "NORMAL", null, 
				new String[]{"PSYCHIC", "GHOST"},new String[]{"NORMAL", "GROUND", "STEEL"}));
		
		pokemons.add(new PokemonTemplate("Raikou", 3307, 262, "ELECTRIC", null, 
				new String[]{"ELECTRIC"},new String[]{"ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Zapdos", 3282, 153, "ELECTRIC", "FLYING", 
				new String[]{"ELECTRIC"},new String[]{"ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Rhydon", 3253, 176, "GROUND", "ROCK", 
				new String[]{"GROUND", "FIGHTING"},new String[]{"BUG", "GROUND", "ROCK", "WATER"}));
		
		pokemons.add(new PokemonTemplate("Gyarados", 3234, 160, "WATER", "FLYING", 
				new String[]{"DARK", "WATER", "DRAGON"},new String[]{"WATER", "DRAGON", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Moltres", 3377, 230, "FIRE", "FLYING", 
				new String[]{"FIRE"},new String[]{"FIRE"}));

		pokemons.add(new PokemonTemplate("Blissey", 3173, 411, "NORMAL", null, 
				new String[]{"PSYCHIC", "NORMAL"},new String[]{"NORMAL", "PSYCHIC", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Vaporeon", 3112, 215, "WATER", null, 
				new String[]{"WATER"},new String[]{"WATER"}));
		
		pokemons.add(new PokemonTemplate("Celebi", 3112, 215, "PSYCHIC", "GRASS", 
				new String[]{"PSYCHIC", "ELECTRIC"},new String[]{"PSYCHIC", "FAIRY", "NORMAL"}));
		
		pokemons.add(new PokemonTemplate("Jirachi", 3112, 215, "STEEL", "PSYCHIC", 
				new String[]{"PSYCHIC", "ELECTRIC"},new String[]{"PSYCHIC", "FAIRY", "STEEL"}));
		
		pokemons.add(new PokemonTemplate("Mew", 3112, 215, "PSYCHIC", null, 
				new String[]{"GHOST", "ICE", "NORMAL", "POISON", "STEEL", "FIGHTING", "ELECTRIC", "DRAGON", "BUG", "DARK", "WATER"},
				new String[]{"DRAGON", "WATER", "GRASS", "FIRE", "STEEL", "ELECTRIC", "FIGHTING", "PSYCHIC", "GROUND", "FAIRY", "NORMAL", "ROCK", "ICE", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Donphan", 2979, 153, "GROUND", null, 
				new String[]{"NORMAL", "FIGHTING"},new String[]{"GROUND", "STEEL", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Regice", 2979, 153, "ICE", null, 
				new String[]{"ICE", "FIGHTING"},new String[]{"GROUND", "ICE", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Regirock", 2979, 153, "ROCK", null, 
				new String[]{"ROCK", "FIGHTING"},new String[]{"ROCK", "FIGHTING", "ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Aggron", 2979, 153, "STEEL", "ROCK", 
				new String[]{"DRAGON", "STEEL"},new String[]{"ROCK", "STEEL", "ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Espeon", 2958, 113, "PSYCHIC", null, 
				new String[]{"PSYCHIC"},new String[]{"PSYCHIC"}));
		
		pokemons.add(new PokemonTemplate("Milotic", 2958, 113, "WATER", null, 
				new String[]{"DRAGON", "WATER"},new String[]{"NORMAL", "ICE", "WATER"}));
		
		pokemons.add(new PokemonTemplate("Gardevoir", 2896, 137, "PSYCHIC", "FAIRY", 
				new String[]{"PSYCHIC", "ELECTRIC"},new String[]{"GHOST", "FAIRY", "PSYCHIC"}));
		
		pokemons.add(new PokemonTemplate("Heracross", 2896, 137, "BUG", "FIGHTING", 
				new String[]{"FIGHTING", "BUG"},new String[]{"FIGHTING", "BUG", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Articuno", 2896, 137, "ICE", "FLYING", 
				new String[]{"ICE"},new String[]{"ICE"}));
		
		pokemons.add(new PokemonTemplate("Golem", 2875, 137, "ROCK", "GROUND", 
				new String[]{"ROCK", "GROUND"},new String[]{"GROUND", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Golem-Alola", 2875, 137, "ROCK", "ELECTRIC", 
				new String[]{"ROCK", "ELECTRIC"},new String[]{"ELECTRIC", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Exeggutor", 2875, 160, "GRASS", "PSYCHIC", 
				new String[]{"GRASS", "PSYCHIC"},new String[]{"GRASS", "PSYCHIC"}));
		
		pokemons.add(new PokemonTemplate("Exeggutor-Alola", 2875, 160, "GRASS", "DRAGON", 
				new String[]{"GRASS", "DRAGON"},new String[]{"GRASS", "DRAGON"}));
		
		pokemons.add(new PokemonTemplate("Flareon", 2863, 113, "FIRE", null, 
				new String[]{"FIRE"},new String[]{"FIRE"}));
		
		pokemons.add(new PokemonTemplate("Machamp", 2848, 153, "FIGHTING", null, 
				new String[]{"STEEL", "FIGHTING"},new String[]{"FIGHTING", "STEEL", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Alakazam", 2845, 98, "PSYCHIC", null, 
				new String[]{"PSYCHIC"},new String[]{"PSYCHIC", "GHOST", "FIGHTING", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Arcanine", 2799, 153, "FIRE", null, 
				new String[]{"FIRE", "DARK"},new String[]{"FIRE", "DARK", "ELECTRIC", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Suicune", 2799, 153, "WATER", null, 
				new String[]{"PSYCHIC", "DARK", "NORMAL"},new String[]{"WATER"}));
		
		pokemons.add(new PokemonTemplate("Swampert", 2799, 153, "WATER", "GROUND", 
				new String[]{"WATER", "GROUND"},new String[]{"WATER", "GROUND", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Scizor", 2761, 121, "BUG", "STEEL", 
				new String[]{"BUG", "STEEL"},new String[]{"BUG", "STEEL", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Pinsir", 2730, 113, "BUG", null, 
				new String[]{"BUG", "FIGHTING"},new String[]{"BUG", "FIGHTING", "NORMAL"}));
		
		pokemons.add(new PokemonTemplate("Hariyama", 2730, 113, "FIGHTING", null, 
				new String[]{"STEEL", "FIGHTING"},new String[]{"STEEL", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Ursaring", 2720, 153, "NORMAL", null, 
				new String[]{"STEEL", "FIGHTING"},new String[]{"FAIRY", "FIGHTING", "NORMAL"}));
		
		pokemons.add(new PokemonTemplate("Jolteon", 2691, 113, "ELECTRIC", null, 
				new String[]{"ELECTRIC"},new String[]{"ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Feraligatr", 2682, 145, "WATER", null, 
				new String[]{"WATER", "DARK"},new String[]{"WATER", "ICE", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Muk", 2670, 176, "POISON", null, 
				new String[]{"POISON", "BUG"},new String[]{"POISON", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Muk-Alola", 2670, 176, "POISON", "DARK", 
				new String[]{"POISON", "DARK"},new String[]{"POISON", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Kingler", 2656, 98, "WATER", null, 
				new String[]{"WATER", "STEEL", "GROUND"},new String[]{"BUG", "WATER", "NORMAL"}));
		
		pokemons.add(new PokemonTemplate("Ampharos", 2656, 153, "ELECTRIC", null, 
				new String[]{"ELECTRIC"},new String[]{"ELECTRIC", "FIGHTING", "DRAGON"}));
		
		pokemons.add(new PokemonTemplate("Charizard", 2648, 134, "FIRE", "FLYING", 
				new String[]{"FIRE", "FLYING"},new String[]{"FIRE", "DRAGON"}));
		
		pokemons.add(new PokemonTemplate("Typhlosion", 2648, 134, "FIRE", null, 
				new String[]{"FIRE", "GHOST"},new String[]{"FIRE", "GRASS"}));
		
		pokemons.add(new PokemonTemplate("Omastar", 2647, 121, "ROCK", "WATER", 
				new String[]{"WATER", "GROUND", "ROCK"},new String[]{"WATER", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Armaldo", 2647, 121, "ROCK", "BUG", 
				new String[]{"BUG"},new String[]{"WATER", "ROCK", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Blaziken", 2647, 121, "FIRE", "FIGHTING", 
				new String[]{"FIRE", "FIGHTING"},new String[]{"FIRE", "FIGHTING", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Gengar", 2581, 105, "GHOST", "POISON", 
				new String[]{"GHOST", "DARK"},new String[]{"GHOST", "POISON", "FIGHTING", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Aerodactyl", 2571, 137, "ROCK", "FLYING", 
				new String[]{"STEEL", "DARK"},new String[]{"ROCK", "STEEL", "NORMAL"}));
		
		pokemons.add(new PokemonTemplate("Walrein", 2571, 137, "WATER", "ICE", 
				new String[]{"WATER", "ICE"},new String[]{"GROUND", "WATER", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Lapras", 2566, 215, "WATER", "ICE", 
				new String[]{"WATER", "ICE"},new String[]{"WATER", "ICE", "DRAGON"}));
		
		pokemons.add(new PokemonTemplate("Sceptile", 2566, 215, "GRASS", null, 
				new String[]{"BUG", "GRASS"},new String[]{"GRASS", "FLYING", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Venusaur", 2531, 137, "GRASS", "POISON", 
				new String[]{"GRASS"},new String[]{"GRASS", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Relicanth", 2531, 137, "WATER", "ROCK", 
				new String[]{"WATER", "PSYCHIC"},new String[]{"WATER", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Porygon2", 2509, 145, "NORMAL", null, 
				new String[]{"NORMAL", "ELECTRIC"},new String[]{"NORMAL", "ELECTRIC", "GRASS"}));
		
		pokemons.add(new PokemonTemplate("Houndoom", 2493, 129, "FIRE", "DARK", 
				new String[]{"FIRE", "DARK"},new String[]{"FIRE", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Kabutops", 2481, 105, "WATER", "ROCK", 
				new String[]{"GROUND", "FIGHTING", "BUG"},new String[]{"WATER", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Jynx", 2476, 113, "ICE", "PSYCHIC", 
				new String[]{"PSYCHIC", "ICE", "NORMAL"},new String[]{"PSYCHIC", "ICE", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Tauros", 2452, 129, "NORMAL", null, 
				new String[]{"NORMAL", "PSYCHIC"},new String[]{"NORMAL", "STEEL", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Slowbro", 2446, 160, "WATER", "PSYCHIC", 
				new String[]{"WATER", "PSYCHIC"},new String[]{"WATER", "ICE", "PSYCHIC"}));
		
		pokemons.add(new PokemonTemplate("Slowking", 2446, 160, "WATER", "PSYCHIC", 
				new String[]{"WATER", "PSYCHIC"},new String[]{"FIRE", "PSYCHIC", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Cloyster", 2439, 90, "WATER", "ICE", 
				new String[]{"ICE"},new String[]{"WATER", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Crobat", 2431, 145, "POISON", "FLYING", 
				new String[]{"DARK", "FLYING"},new String[]{"GHOST", "FLYING", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Scyther", 2429, 121, "BUG", "FLYING", 
				new String[]{"BUG", "FLYING", "STEEL"},new String[]{"BUG", "FLYING", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Kangaskhan", 2428, 176, "NORMAL", null, 
				new String[]{"FIGHTING", "GROUND"},new String[]{"GROUND", "DRAGON", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Flygon", 2407, 153, "GROUND", "DRAGON", 
				new String[]{"DRAGON", "GROUND"},new String[]{"GROUND", "DRAGON", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Poliwrath", 2407, 153, "WATER", "FIGHTING", 
				new String[]{"WATER", "FIGHTING", "GROUND"},new String[]{"WATER", "ICE", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Granbull", 2406, 153, "FAIRY", null, 
				new String[]{"DARK"},new String[]{"DARK", "FIGHTING", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Steelix", 2404, 129, "STEEL", "GROUND", 
				new String[]{"STEEL", "DRAGON"},new String[]{"STEEL", "DARK", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Kingdra", 2389, 129, "WATER", "DRAGON", 
				new String[]{"WATER", "DRAGON"},new String[]{"WATER", "DRAGON", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Breloom", 2389, 129, "GRASS", "FIGHTING", 
				new String[]{"GRASS", "FIGHTING"},new String[]{"GRASS", "FIGHTING", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Hitmonlee", 2372, 90, "FIGHTING", null, 
				new String[]{"FIGHTING"},new String[]{"FIGHTING", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Nidoking", 2352, 138, "POISON", "GROUND", 
				new String[]{"POISON", "STEEL", "BUG"},new String[]{"GROUND", "POISON", "BUG"}));
		
		pokemons.add(new PokemonTemplate("Tentacruel", 2340, 137, "WATER", "POISON", 
				new String[]{"POISON"},new String[]{"ICE", "POISON", "WATER"}));
		
		pokemons.add(new PokemonTemplate("Politoed", 2337, 153, "WATER", null, 
				new String[]{"WATER", "GROUND"},new String[]{"WATER", "GROUND", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Vileplume", 2334, 129, "GRASS", "POISON", 
				new String[]{"GRASS", "POISON"},new String[]{"GRASS", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Clefable", 2320, 160, "FAIRY", null, 
				new String[]{"ELECTRIC", "PSYCHIC", "NORMAL"},new String[]{"PSYCHIC", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Nidoqueen", 2304, 153, "GROUND", "POISON", 
				new String[]{"POISON", "DARK"},new String[]{"POISON", "GROUND", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Sandslash", 2294, 129, "GROUND", null, 
				new String[]{"STEEL", "GROUND"},new String[]{"GROUND", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Sandslash-Alola", 2294, 129, "ICE", "STEEL", 
				new String[]{"STEEL", "ICE"},new String[]{"GROUND", "STEEL", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Crawdaunt", 2294, 129, "WATER", "DARK", 
				new String[]{"DARK", "WATER"},new String[]{"DARK", "WATER", "NORMAL"}));
		
		pokemons.add(new PokemonTemplate("Miltank", 2279, 160, "NORMAL", null, 
				new String[]{"NORMAL", "PSYCHIC"},new String[]{"NORMAL", "STEEL"}));
		
		pokemons.add(new PokemonTemplate("Grumpig", 2279, 160, "PSYCHIC", null, 
				new String[]{"ELECTRIC", "PSYCHIC"},new String[]{"GHOST", "PSYCHIC"}));
		
		pokemons.add(new PokemonTemplate("Starmie", 2270, 105, "WATER", "PSYCHIC", 
				new String[]{"NORMAL", "WATER"},new String[]{"WATER", "PSYCHIC", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Blastoise", 2259, 135, "WATER", null, 
				new String[]{"DARK", "WATER"},new String[]{"WATER", "STEEL", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Piloswine", 2252, 168, "ICE", "GROUND", 
				new String[]{"ICE"},new String[]{"ICE", "GROUND", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Gorebyss", 2252, 168, "WATER", null, 
				new String[]{"WATER", "PSYCHIC"},new String[]{"WATER", "PSYCHIC", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Absol", 2252, 168, "DARK", null, 
				new String[]{"DARK", "PSYCHIC"},new String[]{"DARK", "BUG", "ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Golduck", 2238, 137, "WATER", null, 
				new String[]{"PSYCHIC", "WATER"},new String[]{"WATER", "PSYCHIC", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Victreebel", 2236, 137, "GRASS", "POISON", 
				new String[]{"GRASS", "POISON"},new String[]{"GRASS", "POISON"}));

		pokemons.add(new PokemonTemplate("Exploud", 2236, 137, "NORMAL", null, 
				new String[]{"DARK", "GHOST"},new String[]{"DARK", "FAIRY", "FIRE"}));

		pokemons.add(new PokemonTemplate("Forretress", 2231, 129, "BUG", "STEEL", 
				new String[]{"BUG"},new String[]{"STEEL", "GROUND", "ROCK"}));
				
		pokemons.add(new PokemonTemplate("Wailord", 2222, 113, "WATER", null, 
				new String[]{"WATER", "PSYCHIC"},new String[]{"NORMAL", "WATER", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Magmar", 2222, 113, "FIRE", null, 
				new String[]{"FIRE", "FIGHTING"},new String[]{"FIRE"}));
		
		pokemons.add(new PokemonTemplate("Rapidash", 2220, 113, "FIRE", null, 
				new String[]{"FIRE", "FIGHTING"},new String[]{"FIRE", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Lunatone", 2220, 113, "ROCK", "PSYCHIC", 
				new String[]{"ROCK", "PSYCHIC"},new String[]{"ROCK", "PSYCHIC", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Solrock", 2220, 113, "ROCK", "PSYCHIC", 
				new String[]{"ROCK", "PSYCHIC"},new String[]{"ROCK", "PSYCHIC", "GRASS"}));
		
		pokemons.add(new PokemonTemplate("Magneton", 2205, 90, "ELECTRIC", "STEEL", 
				new String[]{"ELECTRIC"},new String[]{"ELECTRIC", "STEEL"}));
		
		pokemons.add(new PokemonTemplate("Ludicolo", 2205, 90, "WATER", "GRASS", 
				new String[]{"WATER", "GRASS"},new String[]{"WATER", "GRASS", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Meganium", 2195, 137, "GRASS", null, 
				new String[]{"GRASS"},new String[]{"GRASS", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Zangoose", 2177, 113, "NORMAL", null, 
				new String[]{"BUG", "GHOST"},new String[]{"GROUND", "DARK", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Tangela", 2177, 113, "GRASS", null, 
				new String[]{"GRASS", "BUG"},new String[]{"GRASS", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Electabuzz", 2165, 113, "ELECTRIC", null, 
				new String[]{"ELECTRIC", "FIGHTING"},new String[]{"ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Shiftry", 2152, 113, "GRASS", "DARK", 
				new String[]{"GRASS", "DARK"},new String[]{"GRASS", "DARK", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Weezing", 2152, 113, "POISON", null, 
				new String[]{"NORMAL", "BUG", "POISON"},new String[]{"POISON", "DARK", "GHOST"}));
		
		pokemons.add(new PokemonTemplate("Ninetales", 2127, 126, "FIRE", null, 
				new String[]{"DARK", "FIRE"},new String[]{"FIRE", "GRASS"}));
		
		pokemons.add(new PokemonTemplate("Ninetales-Alola", 2127, 126, "ICE", "FAIRY", 
				new String[]{"DARK", "ICE"},new String[]{"ICE", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Huntail", 2108, 105, "WATER", null, 
				new String[]{"DARK", "WATER"},new String[]{"DARK", "WATER", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Dodrio", 2108, 105, "NORMAL", "FLYING", 
				new String[]{"DARK", "STEEL"},new String[]{"FLYING"}));
		
		pokemons.add(new PokemonTemplate("Octillery", 2094, 129, "WATER", null, 
				new String[]{"WATER", "GROUND"},new String[]{"ICE", "WATER", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Bellossom", 2078, 129, "GRASS", null, 
				new String[]{"GRASS", "POISON"},new String[]{"GRASS", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Primeape", 2075, 113, "FIGHTING", null, 
				new String[]{"FIGHTING"},new String[]{"FIGHTING", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Hitmonchan", 2069, 90, "FIGHTING", null, 
				new String[]{"FIGHTING", "STEEL"},new String[]{"FIRE", "ICE", "FIGHTING", "ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Chimecho", 2069, 90, "PSYCHIC", null, 
				new String[]{"PSYCHIC", "GHOST"},new String[]{"PSYCHIC", "GHOST", "GRASS"}));
		
		pokemons.add(new PokemonTemplate("Cacturne", 2069, 90, "GRASS", "DARK", 
				new String[]{"DARK", "POISON"},new String[]{"DARK", "GRASS", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Cradily", 2069, 90, "ROCK", "GRASS", 
				new String[]{"POISON", "BUG"},new String[]{"GROUND", "GRASS", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Lanturn", 2047, 207, "WATER", "ELECTRIC", 
				new String[]{"WATER", "ELECTRIC"},new String[]{"WATER", "ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Banette", 2047, 207, "GHOST", null, 
				new String[]{"GHOST"},new String[]{"GHOST", "ELECTRIC", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Sudowoodo", 2035, 121, "ROCK", null, 
				new String[]{"ROCK", "FIGHTING"},new String[]{"GROUND", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Umbreon", 2023, 160, "DARK", null, 
				new String[]{"DARK"},new String[]{"DARK"}));
		
		pokemons.add(new PokemonTemplate("Hypno", 2019, 145, "PSYCHIC", null, 
				new String[]{"PSYCHIC"},new String[]{"PSYCHIC", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Sunflora", 2019, 129, "GRASS", null, 
				new String[]{"GRASS"},new String[]{"GRASS", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Seaking", 2011, 137, "WATER", null, 
				new String[]{"FLYING", "POISON"},new String[]{"WATER", "BUG", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Noctowl", 2011, 168, "NORMAL", "FLYING", 
				new String[]{"FLYING", "PSYCHIC"},new String[]{"FLYING", "PSYCHIC", "GHOST"}));
		
		pokemons.add(new PokemonTemplate("Mantine", 2003, 113, "WATER", "FLYING", 
				new String[]{"WATER", "FLYING"},new String[]{"WATER", "FLYING", "ICE"}));
		
		pokemons.add(new PokemonTemplate("Skarmory", 2003, 113, "STEEL", "FLYING", 
				new String[]{"STEEL", "FLYING"},new String[]{"STEEL", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Raichu", 1996, 105, "ELECTRIC", null, 
				new String[]{"ELECTRIC"},new String[]{"ELECTRIC", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Pidgeot", 1996, 142, "NORMAL", "FLYING", 
				new String[]{"STEEL", "FLYING"},new String[]{"FLYING"}));
		
		pokemons.add(new PokemonTemplate("Stantler", 1960, 126, "NORMAL", null, 
				new String[]{"NORMAL", "PSYCHIC"},new String[]{"NORMAL", "BUG", "ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Xatu", 1947, 113, "PSYCHIC", "FLYING", 
				new String[]{"DARK", "FLYING"},new String[]{"FLYING", "GHOST", "PSYCHIC"}));
		
		pokemons.add(new PokemonTemplate("Venomoth", 1910, 121, "BUG", "POISON", 
				new String[]{"BUG", "PSYCHIC"},new String[]{"BUG", "PSYCHIC"}));
		
		pokemons.add(new PokemonTemplate("Quagsire", 1902, 160, "WATER", "GROUND", 
				new String[]{"WATER", "GROUND"},new String[]{"GROUND", "ROCK", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Qwilfish", 1883, 113, "WATER", "POISON", 
				new String[]{"WATER", "POISON"},new String[]{"ICE", "WATER", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Wigglytuff", 1879, 231, "NORMAL", "FAIRY", 
				new String[]{"NORMAL", "DARK"},new String[]{"NORMAL", "FAIRY"}));
		
		pokemons.add(new PokemonTemplate("Hitmontop", 1878, 90, "FIGHTING", null, 
				new String[]{"FIGHTING"},new String[]{"STEEL", "ROCK", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Electrode", 1873, 105, "ELECTRIC", null, 
				new String[]{"ELECTRIC"},new String[]{"ELECTRIC", "NORMAL"}));
		
		pokemons.add(new PokemonTemplate("Dewgong", 1867, 153, "WATER", "ICE", 
				new String[]{"ICE", "STEEL"},new String[]{"ICE", "WATER"}));
		
		pokemons.add(new PokemonTemplate("Sneasel", 1841, 98, "ICE", "DARK", 
				new String[]{"ICE", "DARK"},new String[]{"ICE", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Girafarig", 1836, 121, "NORMAL", "PSYCHIC", 
				new String[]{"NORMAL", "PSYCHIC"},new String[]{"PSYCHIC", "ELECTRIC"}));
		
		pokemons.add(new PokemonTemplate("Fearow", 1788, 113, "NORMAL", "FLYING", 
				new String[]{"FLYING", "STEEL"},new String[]{"FLYING", "GROUND", "DRAGON"}));
		
		pokemons.add(new PokemonTemplate("Misdreavus", 1756, 105, "GHOST", null, 
				new String[]{"GHOST"},new String[]{"GHOST", "DARK"}));
		
		pokemons.add(new PokemonTemplate("Beedrill", 1752, 113, "BUG", "POISON", 
				new String[]{"POISON", "BUG"},new String[]{"POISON", "BUG", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Gligar", 1733, 113, "GROUND", "FLYING", 
				new String[]{"BUG", "FLYING"},new String[]{"GROUND", "DARK", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Arbok", 1733, 113, "POISON", null, 
				new String[]{"DARK", "POISON"},new String[]{"DARK", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Butterfree", 1677, 105, "BUG", "FLYING", 
				new String[]{"PSYCHIC", "BUG"},new String[]{"PSYCHIC", "BUG"}));
		
		pokemons.add(new PokemonTemplate("Marowak", 1677, 105, "GROUND", null, 
				new String[]{"GROUND", "FIGHTING"},new String[]{"GROUND"}));
		
		pokemons.add(new PokemonTemplate("Furret", 1643, 145, "NORMAL", null, 
				new String[]{"DARK", "NORMAL"},new String[]{"GROUND", "NORMAL", "FIGHTING"}));
		
		pokemons.add(new PokemonTemplate("Parasect", 1633, 105, "BUG", "GRASS", 
				new String[]{"BUG"},new String[]{"BUG", "GRASS", "POISON"}));
		
		pokemons.add(new PokemonTemplate("Ariados", 1613, 121, "BUG", "POISON", 
				new String[]{"POISON", "BUG"},new String[]{"POISON", "BUG", "GHOST"}));
		
		pokemons.add(new PokemonTemplate("Dunsparce", 1592, 168, "NORMAL", null, 
				new String[]{"DARK", "GHOST"},new String[]{"GROUND", "ROCK"}));
		
		pokemons.add(new PokemonTemplate("Jumpluff", 1531, 129, "FLYING", "GRASS", 
				new String[]{"BUG", "GRASS"},new String[]{"FAIRY", "GRASS"}));

		pokemons.add(new PokemonTemplate("Raticate", 1527, 98, "NORMAL", null, 
				new String[]{"DARK", "NORMAL"},new String[]{"NORMAL", "GROUND"}));
		
		pokemons.add(new PokemonTemplate("Togetic", 1521, 98, "FLYING", "FAIRY", 
				new String[]{"PSYCHIC", "NORMAL"},new String[]{"FAIRY", "GROUND", "FLYING"}));

		pokemons.add(new PokemonTemplate("Magcargo", 1521, 90, "FIRE", "ROCK", 
				new String[]{"FIRE", "ROCK"},new String[]{"FIRE", "ROCK"}));

		pokemons.add(new PokemonTemplate("Azumarill", 1481, 168, "WATER", "FAIRY", 
				new String[]{"WATER", "FIGHTING"},new String[]{"WATER", "FAIRY", "ICE"}));
				
		pokemons.add(new PokemonTemplate("Murkrow", 1372, 105, "DARK", "FLYING", 
				new String[]{"DARK", "FLYING"},new String[]{"DARK", "FLYING"}));
		
		pokemons.add(new PokemonTemplate("Yanma", 1308, 113, "BUG", "FLYING", 
				new String[]{"NORMAL", "FLYING"},new String[]{"FLYING", "ROCK", "BUG"}));
		
		pokemons.add(new PokemonTemplate("Lickitung", 1303, 153, "NORMAL", null, 
				new String[]{"GHOST", "PSYCHIC"},new String[]{"NORMAL", "GRASS"}));
		
		pokemons.add(new PokemonTemplate("Aipom", 1171, 98, "NORMAL", null, 
				new String[]{"NORMAL", "GHOST"},new String[]{"FLYING", "FIGHTING", "NORMAL"}));
		
		pokemonTemplatesMap = new HashMap<String, PokemonTemplate>();
		
		for ( int i = 0 ; i < pokemons.size(); i++){
			pokemonTemplatesMap.put(pokemons.get(i).getName(), pokemons.get(i));
		}
	}
	
	public static PokemonTemplate getPokemonTemplate (String name){
		return pokemonTemplatesMap.get(name);
	}

	public static ArrayList<Pokemon> getPokemons(String name) {
		return getPokemons(getPokemonTemplate(name));
	}

	public static ArrayList<Pokemon> getPokemons(PokemonTemplate pt) {
		ArrayList<Pokemon> ret = new ArrayList<Pokemon>();

		if ( pt != null ) {
			for (int i = 0; i < pt.getMove1().length; i++) {
				for (int j = 0; j < pt.getMove2().length; j++) {
					ret.add(new Pokemon(pt.getName(), pt.getType1(), pt.getType2(),
							pt.getMove1()[i], pt.getMove2()[j]));
	
				}
			}
		}

		return ret;
	}
}
