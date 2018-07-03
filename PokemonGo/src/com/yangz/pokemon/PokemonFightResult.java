package com.yangz.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import com.yangz.pokemon.datatype.Pokemon;

public class PokemonFightResult {

	String pokemonName = null;
	//All Factors Against this Pokemon
	TreeSet<Double> factors = null;
	HashMap<Double, ArrayList<Pokemon>> results = null;
	
	TreeSet<StrongAgaintRanking> strongAgainstRanking = null;
	HashMap<StrongAgaintRanking, ArrayList<Pokemon>> strongAgainstPokemons = null;
	
	public PokemonFightResult(String pokemonName) {
		super();
		this.pokemonName = pokemonName;
	}
	
	public String getPokemonName() {
		return pokemonName;
	}
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	public HashMap<Double, ArrayList<Pokemon>> getResults() {
		return results;
	}
	public void setResults(HashMap<Double, ArrayList<Pokemon>> results) {
		this.results = results;
	}
	public TreeSet<Double> getFactors() {
		return factors;
	}
	public void setFactors(TreeSet<Double> factors) {
		this.factors = factors;
	}

	public Double getMostEffectiveFactor() {
		return factors.first();
	}
	
	public Double getnthEffectiveFactor(int n) {
		int NumberOfEnemies = 0;
		Double ret = null;
		Iterator<Double> dd = factors.iterator();
		while (dd.hasNext()){
			ret = dd.next();
			NumberOfEnemies += results.get(ret).size();
			if ( NumberOfEnemies >= n ){
				break;				
			}
		}
		return ret;
	}
	
	
	public String getMostEffectiveFoes(int n) {
		String ret = "";
		Iterator<Double> dd = factors.iterator();
		while (dd.hasNext()){
			ArrayList<Pokemon> p = results.get(dd.next());
			for ( int i =0 ; i < p.size() && i < n; i++){
				ret = ret + p.get(i).getPrintName() + " ";
				if ( i > 0 && i % 4 == 0){
					ret += "<br>";
				}
			}
			break; // only display the first set
		}
		return ret;
	}
	
	public String getFoes(Double d) {
		String ret = "";
		if ( results.containsKey(d)) {
			ArrayList<Pokemon> p = results.get(d);
			for ( int i =0 ; i < p.size(); i++){
				ret = ret + p.get(i).getPrintName() + " ";
				if ( i > 0 && i % 4 == 0){
					//ret += "<br>";
				}
			}
		}
		return ret;
	}
	
	public void printEverything(Double filterD) {
		Iterator<Double> dd = factors.iterator();
		while (dd.hasNext()){
			Double thisD = dd.next();
			if (( thisD > 0d && thisD > filterD ) || ( thisD < 0d && thisD < 0 - filterD )) {
				System.out.println(thisD);
				
				ArrayList<Pokemon> p = results.get(thisD);
				for ( int i =0 ; i < p.size(); i++){
					System.out.println(p.get(i).getPrintName());
				}
			}
		}
		return;
	}
	
	public TreeSet<StrongAgaintRanking> getStrongAgainstRanking() {
		return strongAgainstRanking;
	}

	public void setStrongAgainstRanking(
			TreeSet<StrongAgaintRanking> strongAgainstRanking) {
		this.strongAgainstRanking = strongAgainstRanking;
	}

	public HashMap<StrongAgaintRanking, ArrayList<Pokemon>> getStrongAgainstPokemons() {
		return strongAgainstPokemons;
	}

	public void setStrongAgainstPokemons(
			HashMap<StrongAgaintRanking, ArrayList<Pokemon>> strongAgainstPokemons) {
		this.strongAgainstPokemons = strongAgainstPokemons;
	}
	
}
