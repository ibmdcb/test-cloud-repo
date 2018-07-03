package com.yangz.pokemon.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TypeMoveChart {

	public static HashMap<String, Double> factorChart;
	
	public static ArrayList<String> types;
	
	static {
		types = new ArrayList<String>();
		types.add("NORMAL");
		types.add("FIRE");
		types.add("WATER");
		types.add("ELECTRIC");
		types.add("GRASS");
		types.add("ICE");
		types.add("FIGHTING");
		types.add("POISON");
		types.add("GROUND");
		types.add("FLYING");
		types.add("PSYCHIC");
		types.add("BUG");
		types.add("ROCK");
		types.add("GHOST");
		types.add("DRAGON");
		types.add("DARK");
		types.add("FAIRY");
		types.add("STEEL");
		
		factorChart = new HashMap<String, Double>();
		
		factorChart.put("NORMAL_ROCK", Double.valueOf(0.5d));
		factorChart.put("NORMAL_GHOST", Double.valueOf(0d));
		factorChart.put("NORMAL_STEEL", Double.valueOf(0.5d));
		
		factorChart.put("FIRE_FIRE", Double.valueOf(0.5d));
		factorChart.put("FIRE_WATER", Double.valueOf(0.5d));
		factorChart.put("FIRE_ROCK", Double.valueOf(0.5d));
		factorChart.put("FIRE_DRAGON", Double.valueOf(0.5d));

		factorChart.put("FIRE_GRASS", Double.valueOf(2d));
		factorChart.put("FIRE_ICE", Double.valueOf(2d));
		factorChart.put("FIRE_BUG", Double.valueOf(2d));
		factorChart.put("FIRE_STEEL", Double.valueOf(2d));
		
		
		factorChart.put("WATER_WATER", Double.valueOf(0.5d));
		factorChart.put("WATER_GRASS", Double.valueOf(0.5d));
		factorChart.put("WATER_DRAGON", Double.valueOf(0.5d));
		
		factorChart.put("WATER_FIRE", Double.valueOf(2d));
		factorChart.put("WATER_GROUND", Double.valueOf(2d));
		factorChart.put("WATER_ROCK", Double.valueOf(2d));

	
		factorChart.put("ELECTRIC_ELECTRIC", Double.valueOf(0.5d));
		factorChart.put("ELECTRIC_GRASS", Double.valueOf(0.5d));
		factorChart.put("ELECTRIC_GROUND", Double.valueOf(0d));
		factorChart.put("ELECTRIC_DRAGON", Double.valueOf(0.5d));
		
		factorChart.put("ELECTRIC_WATER", Double.valueOf(2d));
		factorChart.put("ELECTRIC_FLYING", Double.valueOf(2d));
		
		factorChart.put("GRASS_FIRE", Double.valueOf(0.5d));
		factorChart.put("GRASS_GRASS", Double.valueOf(0.5d));
		factorChart.put("GRASS_POISON", Double.valueOf(0.5d));
		factorChart.put("GRASS_FLYING", Double.valueOf(0.5d));
		factorChart.put("GRASS_BUG", Double.valueOf(0.5d));
		factorChart.put("GRASS_DRAGON", Double.valueOf(0.5d));
		factorChart.put("GRASS_STEEL", Double.valueOf(0.5d));
		
		factorChart.put("GRASS_WATER", Double.valueOf(2d));
		factorChart.put("GRASS_GROUND", Double.valueOf(2d));
		factorChart.put("GRASS_ROCK", Double.valueOf(2d));
		
		factorChart.put("ICE_FIRE", Double.valueOf(0.5d));
		factorChart.put("ICE_WATER", Double.valueOf(0.5d));
		factorChart.put("ICE_ICE", Double.valueOf(0.5d));
		factorChart.put("ICE_STEEL", Double.valueOf(0.5d));

		factorChart.put("ICE_GRASS", Double.valueOf(2d));
		factorChart.put("ICE_GROUND", Double.valueOf(2d));
		factorChart.put("ICE_FLYING", Double.valueOf(2d));
		factorChart.put("ICE_DRAGON", Double.valueOf(2d));
		
		factorChart.put("FIGHTING_POISON", Double.valueOf(0.5d));
		factorChart.put("FIGHTING_FLYING", Double.valueOf(0.5d));
		factorChart.put("FIGHTING_PSYCHIC", Double.valueOf(0.5d));
		factorChart.put("FIGHTING_BUG", Double.valueOf(0.5d));
		factorChart.put("FIGHTING_FAIRY", Double.valueOf(0.5d));
		factorChart.put("FIGHTING_GHOST", Double.valueOf(0d));
		
		factorChart.put("FIGHTING_NORMAL", Double.valueOf(2d));
		factorChart.put("FIGHTING_DARK", Double.valueOf(2d));
		factorChart.put("FIGHTING_ICE", Double.valueOf(2d));
		factorChart.put("FIGHTING_STEEL", Double.valueOf(2d));
		factorChart.put("FIGHTING_ROCK", Double.valueOf(2d));
		
		factorChart.put("POISON_POISON", Double.valueOf(0.5d));
		factorChart.put("POISON_GROUND", Double.valueOf(0.5d));
		factorChart.put("POISON_ROCK", Double.valueOf(0.5d));
		factorChart.put("POISON_GHOST", Double.valueOf(0.5d));
		factorChart.put("POISON_STEEL", Double.valueOf(0d));
		
		factorChart.put("POISON_GRASS", Double.valueOf(2d));
		factorChart.put("POISON_FAIRY", Double.valueOf(2d));

		factorChart.put("GROUND_GRASS", Double.valueOf(0.5d));
		factorChart.put("GROUND_FLYING", Double.valueOf(0d));
		factorChart.put("GROUND_BUG", Double.valueOf(0.5d));
		
		factorChart.put("GROUND_FIRE", Double.valueOf(2d));
		factorChart.put("GROUND_ROCK", Double.valueOf(2d));
		factorChart.put("GROUND_ELECTRIC", Double.valueOf(2d));
		factorChart.put("GROUND_POISON", Double.valueOf(2d));
		
		factorChart.put("FLYING_ELECTRIC", Double.valueOf(0.5d));
		factorChart.put("FLYING_ROCK", Double.valueOf(0.5d));
		factorChart.put("FLYING_STEEL", Double.valueOf(0.5d));

		factorChart.put("FLYING_BUG", Double.valueOf(2d));
		factorChart.put("FLYING_GRASS", Double.valueOf(2d));
		factorChart.put("FLYING_FIGHTING", Double.valueOf(2d));

		factorChart.put("PSYCHIC_PSYCHIC", Double.valueOf(0.5d));
		factorChart.put("PSYCHIC_STEEL", Double.valueOf(0.5d));
		factorChart.put("PSYCHIC_DARK", Double.valueOf(0d));

		factorChart.put("PSYCHIC_FIGHTING", Double.valueOf(2d));
		factorChart.put("PSYCHIC_POISON", Double.valueOf(2d));

		factorChart.put("BUG_FIRE", Double.valueOf(0.5d));
		factorChart.put("BUG_FIGHTING", Double.valueOf(0.5d));
		factorChart.put("BUG_POISON", Double.valueOf(0.5d));
		factorChart.put("BUG_FLYING", Double.valueOf(0.5d));
		factorChart.put("BUG_GHOST", Double.valueOf(0.5d));
		factorChart.put("BUG_STEEL", Double.valueOf(0.5d));
		factorChart.put("BUG_FAIRY", Double.valueOf(0.5d));
		
		factorChart.put("BUG_DARK", Double.valueOf(2d));
		factorChart.put("BUG_GRASS", Double.valueOf(2d));
		factorChart.put("BUG_PSYCHIC", Double.valueOf(2d));
	
		factorChart.put("ROCK_FIGHTING", Double.valueOf(0.5d));
		factorChart.put("ROCK_GROUND", Double.valueOf(0.5d));
		factorChart.put("ROCK_STEEL", Double.valueOf(0.5d));
		
		factorChart.put("ROCK_FLYING", Double.valueOf(2d));
		factorChart.put("ROCK_BUG", Double.valueOf(2d));
		factorChart.put("ROCK_ICE", Double.valueOf(2d));
		factorChart.put("ROCK_FIRE", Double.valueOf(2d));
		
		factorChart.put("GHOST_NORMAL", Double.valueOf(0d));
		factorChart.put("GHOST_DARK", Double.valueOf(0.5d));
		
		factorChart.put("GHOST_GHOST", Double.valueOf(2d));
		factorChart.put("GHOST_PSYCHIC", Double.valueOf(2d));
		
		factorChart.put("DRAGON_FAIRY", Double.valueOf(0d));
		factorChart.put("DRAGON_STEEL", Double.valueOf(0.5d));
		
		factorChart.put("DRAGON_DRAGON", Double.valueOf(2d));

		factorChart.put("DARK_FIGHTING", Double.valueOf(0.5d));
		factorChart.put("DARK_DARK", Double.valueOf(0.5d));
		factorChart.put("DARK_FAIRY", Double.valueOf(0.5d));
		
		factorChart.put("DARK_GHOST", Double.valueOf(2d));
		factorChart.put("DARK_PSYCHIC", Double.valueOf(2d));
		
		factorChart.put("STEEL_FIRE", Double.valueOf(0.5d));
		factorChart.put("STEEL_WATER", Double.valueOf(0.5d));
		factorChart.put("STEEL_ELECTRIC", Double.valueOf(0.5d));
		factorChart.put("STEEL_STEEL", Double.valueOf(0.5d));
		
		factorChart.put("STEEL_ROCK", Double.valueOf(2d));
		factorChart.put("STEEL_ICE", Double.valueOf(2d));
		factorChart.put("STEEL_FAIRY", Double.valueOf(2d));
		
		factorChart.put("FAIRY_FIRE", Double.valueOf(0.5d));
		factorChart.put("FAIRY_POISON", Double.valueOf(0.5d));
		factorChart.put("FAIRY_STEEL", Double.valueOf(0.5d));
		
		factorChart.put("FAIRY_DARK", Double.valueOf(2d));
		factorChart.put("FAIRY_FIGHTING", Double.valueOf(2d));
		factorChart.put("FAIRY_DRAGON", Double.valueOf(2d));
	}

	public static void main(String[] args){
		
		checkNonSymmetrical();		
	}
	
	public static void checkTypos(){
		
		Iterator<String> it= factorChart.keySet().iterator();
		while (it.hasNext()){
			String key = it.next();
			int k = key.indexOf('_');
			String firstType = key.substring(0, k);
			String secondType = key.substring(k+1);
			//System.out.println(firstType + "     " + secondType);
			if ( !types.contains(firstType)){
				System.out.println("First Type Wrong" + firstType + "     " + secondType);				
			}
			
			if ( !types.contains(secondType)){
				System.out.println("Second Type Wrong" + firstType + "     " + secondType);				
			}
		}
		
	}

	public static void checkNonSymmetrical(){

		for ( int i = 0; i < types.size(); i++){
			String firstType = types.get(i);
			
			for ( int j = i+1; j < types.size(); j++){
				String secondType = types.get(j);
				
				double firstAgainstSec = 1d;
				double secAgainstFirst = 1d;
				
				Double temp = null;
				temp = factorChart.get(firstType+"_"+secondType);
				if ( temp != null){
					firstAgainstSec = temp.doubleValue();					
				}
				
				temp = factorChart.get(secondType+"_"+firstType);
				if ( temp != null){
					secAgainstFirst = temp.doubleValue();					
				}
				
				if (firstAgainstSec * secAgainstFirst < 0.99d){
					StringBuffer buf = new StringBuffer()
										.append("")
							.append(firstType).append(" - ").append(secondType)
							.append(" ").append(firstAgainstSec)
							.append(" ").append(secAgainstFirst);
							
					
					System.out.println(buf.toString());
				}
			}
			
		}		
	}

	public static void checkType(String type1) {
		
		if ( type1 !=null ){
			if (!TypeMoveChart.types.contains(type1)){
				System.out.println("Not Found : " + type1);
			}
		}
	}
}
