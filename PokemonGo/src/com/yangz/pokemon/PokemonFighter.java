package com.yangz.pokemon;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import com.yangz.pokemon.data.PokemonRegistry;
import com.yangz.pokemon.data.TypeMoveChart;
import com.yangz.pokemon.datatype.Pokemon;
import com.yangz.pokemon.datatype.PokemonTemplate;

public class PokemonFighter {
	static HashMap<String, PokemonFightResult> fightResults = null;
	static PrintStream fstr = null;
	static {
		try{
			fstr = new PrintStream(new File("c://TEMP//temp.log"));
		}catch( Throwable t){
			t.printStackTrace();
		}
		fightResults = new HashMap<String, PokemonFightResult>();
		fightAll();
		
//		Iterator<String> it = fightResults.keySet().iterator();
//		while (it.hasNext()){
//			PokemonFightResult pokemonResult = fightResults.get(it.next());
//			
//		}
		
	}
	
	static public void main(String[] args) {
		System.out.print("aaa");
		/*
		comparePokemonWithDetail(
				new Pokemon("Snorlax", "NORMAL", null, "PSYCHIC", "STEEL"),
				new Pokemon("URSARING", "NORMAL", null, "FIGHTING", "FIGHTING"));
		*/
		//findMostEffective(new Pokemon("Snorlax", "NORMAL", null, "GHOST", "STEEL"), true, true, 2.1d, true);
		//fightAll(new Pokemon("Qwilfish", "NORMAL", null, "POISON", "POISON"), true);
		//fightAll(new Pokemon("Snorlax", "NORMAL", null, "GHOST", "GROUND"), true);
		//fightAll(new Pokemon("Snorlax", "NORMAL", null, "PSYCHIC", "GROUND"), true);
		//fightAll(new Pokemon("Dragonite", "DRAGON", "FLYING", "DRAGON", "DRAGON"), true);
		//fightAll(new Pokemon("Dragonite", "DRAGON", "FLYING", "DRAGON", "NORMAL"), true);
		//fightAll(new Pokemon("GYARADOS", "POISON", "FLYING", "WATER", "DRAGON"), true);
		
		//fightAll(new Pokemon("Vaporean", "WATER", null, "WATER", "WATER"), true);
		
		//fightAll(new Pokemon("lapras", "GRASS", "PSYCHIC", "ICE", "ICE"), true);
		//fightAll(new Pokemon("Charizard", "FIRE", "FLYING", "FIRE", "FIRE"), true);
		//fightAll(new Pokemon("Flareon", "FIRE", null, "FIRE", "FIRE"), true);
		//fightAll(new Pokemon("Jolteon", "ELECTRIC", null, "ELECTRIC", "ELECTRIC"), true);
		//fightAll(new Pokemon("Kingler", "WATER", null, "GROUND", "BUG"), true);
		//fightAll(new Pokemon("Jynx", "ICE", "PSYCHIC", "ICE", "FAIRY"), true);
		//fightAll(new Pokemon("Magneton", "ELECTRIC", "STEEL", "ELECTRIC", "ELECTRIC"), true);
		//fightAll(new Pokemon("Slowking", "WATER", "PSYCHIC", "WATER", "ICE"), true);
		//fightAll(new Pokemon("Pinsir", "BUG", null, "BUG", "BUG"), true);
		
		//fightAll(new Pokemon("Snorlax", "NORMAL", null, "PSYCHIC", "NORMAL"), true);
		//fightAll(new Pokemon("Dragonite", "FLYING", "DRAGON", "STEEL", "FLYING"), true);
		
		//fightAll(new Pokemon("Dragonite", "FLYING", "DRAGON", "STEEL", "FLYING"), true);
		//fightAll(new Pokemon("Dragonite", "FLYING", "DRAGON", "STEEL", "FLYING"), true);
		//fightAll(new Pokemon("Rhydon", "ROCK", "GROUND", "GROUND", "ROCK"), true);
		//fightAll(new Pokemon("Ursaring", "NORMAL", null, "FIGHTING", "NORMAL"), true);
		//fightAll(new Pokemon("Poliwrath", "WATER", "FIGHTING", "FIGHTING", "FIGHTING"), true);
		//fightAll(new Pokemon("Donphan", "GROUND", null, "FIGHTING", "GROUND"), true);
		//fightAll(new Pokemon("OCTILLERY", "NORMAL", null, "GROUND", "POISON"),true);
		
		//findMostEffective(new Pokemon("URSARING", "NORMAL", null, "NORMAL", "NORMAL"), true, true, 3.1d );
		
		//findStrongAgainst(new Pokemon("Forretress", "WATER", "FIGHTING", "BUG", "ROCK").getPrintName(), true);
		//findStrongAgainst(new Pokemon("Ursaring", "FIRE", "FLYING", "STEEL", "NORMAL").getPrintName(), true);
		//findStrongAgainst(new Pokemon("Xatu", "PSYCHIC", "FLYING", "DARK", "PSYCHIC").getPrintName(), true);
		//findStrongAgainst(new Pokemon("Dunsparce", "NORMAL", null, "DARK", "ROCK").getPrintName(), true);
		//findStrongAgainst(new Pokemon("Groudon", "GROUND", null, "GROUND", "GRASS").getPrintName(), true);
		
		//findMostEffective(new Pokemon("Lugia", "PSYCHIC", "FLYING", "PSYCHIC", "PSYCHIC"), true, true, 1.1d );
		//findMostEffective2(new Pokemon("Alakazam", "PSYCHIC", null, "PSYCHIC", "FIGHTING"), false, true, 1.99d, true);
		findMostEffective2(new Pokemon("Groudon", "GROUND", null, "GROUND", "GROUND"), false, true, 1.99d, true);
		//findMostEffective(new Pokemon("Gengar", "GHOST", "POISON", "GHOST", "FIGHTING"), true, true, 1.99d, true);
		//findMostEffective2(new Pokemon("Gengar", "GHOST", "POISON", "GHOST", "FIGHTING"), true, true, 1.99d, true);
		//findMostEffective(new Pokemon("Alakazam", "PSYCHIC", null, "PSYCHIC", "FIGHTING"), true, false, 1.1d, true);
		//findMostEffective(new Pokemon("Crobat", "POISON", "FLYING", "FLYING", "FLYING"), true, true, 3.1d );
		//findMostEffective(new Pokemon("Lapras", "WATER", "ICE", "ICE", "ICE"), false, true, 2.1d );
		//findMostEffective(new Pokemon("SEAKING", "WATER", null, "FLYING", "BUG"), true, false, 2.0d);
		//findMostEffective(new Pokemon("CHARIZARD", "FIRE", "FLYING", "FIRE", "FIRE"), true, false, 2.0d);
		//findMostEffective(new Pokemon("Omastar", "ROCK", "WATER", "WATER", "ROCK"), true, false, 2.0d);
		//findMostEffective(new Pokemon("Omastar", "ROCK", "WATER", "GROUND", "WATER"), true, false, 2.0d);
		//findMostEffective(new Pokemon("Vaporean", "WATER", null, "WATER", "WATER"), true, false, 2.0d);
		//findMostEffective(new Pokemon("Flareon", "FIRE", null, "FIRE", "FIRE"), false, true, 3.0d);
		//findMostEffective(new Pokemon("Vaporean", "WATER", null, "WATER", "WATER"), false, true, 2.0d, true);
		//findMostEffective(new Pokemon("Exeggutor", "GRASS", "PSYCHIC", "PSYCHIC", "PSYCHIC"), false, true, 2.0d);
		//findMostEffective(new Pokemon("Exeggutor", "GRASS", "PSYCHIC", "GRASS", "PSYCHIC"), false, true, 2.0d);
		//findMostEffective(new Pokemon("Exeggutor", "GRASS", "PSYCHIC", "GRASS", "GRASS"), false, true, 3.1d);
		//findMostEffective(new Pokemon("Arcanine", "FIRE", null, "DARK", "FIRE"), true, false, 3.1d);
		//findMostEffective(new Pokemon("Scizor", "BUG", "STEEL", "BUG", "BUG"), true, true, 3.1d);
		//findMostEffective(new Pokemon("Ursaring", "NORMAL", null, "FIGHTING", "NORMAL"), true, true, 2.1d);
		
		//whichMove("Poliwrath", true, false, 2.4d);
		//whichMove("Gyarados", true, false, 2.0d);
		//whichMove("Steelix", true, false, 3.0d);

		//whichMove("Aerodactyl", true, false, 3.0d);
		
		//whichMove("Arcanine", true, false, 3.0d);
		//whichMove("Rhydon", true, false, 3.0d);
		//whichMove("Muk", true, false, 3.0d);
		//whichMove("Scizor", true, false, 3.0d);
		
		//whichMove("Snorlax", false, true, 2.0d);
		//whichMove("Exeggutor", false, true, 3.0d);
		//whichMove("Dragonite", false, true, 2.0d);
		//whichMove("Gyarados", false, true, 3.0d);
		//whichMove("Vaporeon", false, true, 3.0d);
		
		//whichMove("Snorlax", false, true, 1.9d);
		return;
	}

	static public ArrayList<Pokemon> findMostEffective(Pokemon p1, boolean findStrongAgainst, boolean findWeakAgainst, double threshold) {
		return findMostEffective(p1, findStrongAgainst, findWeakAgainst, threshold, false);
	}
	static public ArrayList<Pokemon> findMostEffective(Pokemon p1, boolean findStrongAgainst, boolean findWeakAgainst, double threshold, boolean toLog) {

		ArrayList<Pokemon> ret = new ArrayList<Pokemon>();
		
		Iterator<PokemonTemplate> it = PokemonRegistry.pokemons.iterator();
		while (it.hasNext()) {
			PokemonTemplate pt = it.next();

			for (int i = 0; i < pt.getMove1().length; i++) {
				for (int j = 0; j < pt.getMove2().length; j++) {
					Pokemon newP = new Pokemon(pt.getName(), pt.getType1(),
							pt.getType2(), pt.getMove1()[i], pt.getMove2()[j]);
					double fs = comparePokemon(p1, newP);
					if ((findStrongAgainst && fs > threshold) || (findWeakAgainst && fs <= 0 - threshold )){
						ret.add(newP);
						if ( toLog){
							System.out.println(p1.getPrintName() + " ---> " + newP.getPrintName() + " : " + fs);
							comparePokemonWithDetail(p1, newP);
						}
					}
				}
			}
		}

		return ret;
	}

	static public void findMostEffective2(Pokemon p1, boolean findStrongAgainst, boolean findWeakAgainst, double threshold, boolean toLog) {

		if ( fightResults.containsKey(p1.getPrintName())){
			
			//fightResults.get(p1.getPrintName()).getFactors();
			fightResults.get(p1.getPrintName()).printEverything(threshold);
			
		} 
		return;
	}
	
	static public void fightAll() {
		
		Iterator<PokemonTemplate> it = PokemonRegistry.pokemons.iterator();
		while (it.hasNext()) {
			PokemonTemplate pt = it.next();
	
			for (int i = 0; i < pt.getMove1().length; i++) {
				for (int j = 0; j < pt.getMove2().length; j++) {
					Pokemon newP = new Pokemon(pt.getName(), pt.getType1(),
							pt.getType2(), pt.getMove1()[i], pt.getMove2()[j]);
					//System.out.println(newP.getPrintName());
					fightAll(newP, false);
					printDefenseStats(newP, true);					
				}
			}
		}

		Iterator<PokemonTemplate> it2 = PokemonRegistry.pokemons.iterator();
		while (it2.hasNext()) {
			PokemonTemplate pt = it2.next();
	
			for (int i = 0; i < pt.getMove1().length; i++) {
				for (int j = 0; j < pt.getMove2().length; j++) {
					Pokemon newP = new Pokemon(pt.getName(), pt.getType1(),
							pt.getType2(), pt.getMove1()[i], pt.getMove2()[j]);
					//System.out.println(newP.getPrintName());
					findStrongAgainst(newP.getPrintName(), false);
				}
			}
		}
}
	
	static public void findStrongAgainst(String pokemonName, boolean toLog) {
		
		
		TreeSet<StrongAgaintRanking> strongAgainstRanking = null; 
		HashMap<StrongAgaintRanking, ArrayList<Pokemon>> strongAgainstPokemons = null;
		
		PokemonFightResult pfs = fightResults.get(pokemonName);
		
		if ( pfs != null && pfs.getStrongAgainstRanking() != null){
			
			strongAgainstRanking = pfs.getStrongAgainstRanking();
			strongAgainstPokemons = pfs.getStrongAgainstPokemons();
			
		} else if ( pfs != null && pfs.strongAgainstRanking == null){
			
			strongAgainstRanking = new TreeSet<StrongAgaintRanking>();
			strongAgainstPokemons = new HashMap<StrongAgaintRanking, ArrayList<Pokemon>>();
			
			TreeSet<Double> rets = pfs.getFactors();
			HashMap<Double, ArrayList<Pokemon>> ret = pfs.getResults();
			
			Iterator<Double> itResults = rets.iterator();
			while (itResults.hasNext()){
				Double thisValue = itResults.next();
				if ( thisValue < 1.0){
					continue;
				}
				ArrayList<Pokemon> list = ret.get(thisValue);
				//System.out.println(thisValue+ " : " + list.size());
				for ( int i = 0; i < list.size(); i++){
					String againstName = list.get(i).getPrintName();
					PokemonFightResult againstPokeResult = fightResults.get(againstName);
					TreeSet<Double> againstPokeFactors = againstPokeResult.getFactors();
					int rankingNumOfPok = 0;
					int rankingNumOfFactor = 0;
					int rankingNumSimilar = 0;
					Iterator<Double> af = againstPokeFactors.iterator();
					while (af.hasNext()){
						Double d = af.next();
						Double posD = 0 - d;
						//System.out.println("" + d + " posD " + posD + " thisvalue " + thisValue);
						if ( posD.toString().equals(thisValue.toString())){
							rankingNumOfFactor++;
							rankingNumSimilar = againstPokeResult.getResults().get(d).size();
							break;
						} else if ( posD > thisValue + 0.01){
							rankingNumOfFactor++;
							rankingNumOfPok += againstPokeResult.getResults().get(d).size();
						} 
					}
					rankingNumOfPok++;
					
					StrongAgaintRanking sA = new StrongAgaintRanking(pokemonName, againstName, thisValue, rankingNumOfFactor, rankingNumOfPok, rankingNumSimilar);
					strongAgainstRanking.add(sA);
					
					if (!strongAgainstPokemons.containsKey(sA)){
						strongAgainstPokemons.put(sA, new ArrayList<Pokemon>());
					}
					strongAgainstPokemons.get(sA).add(list.get(i));						
					
					if ( rankingNumOfPok < 20 && toLog){
						System.out.println("Strong Against :" + againstName + " effectiveness ranking : " + rankingNumOfFactor + ", ranking:" + rankingNumOfPok + ",similar to:" + rankingNumSimilar);
					}
				}//Finish one factor
			}//Finish all factors
			
			pfs.setStrongAgainstPokemons(strongAgainstPokemons);
			pfs.setStrongAgainstRanking(strongAgainstRanking);
			
		} 
		
		if (pfs != null && toLog){
			Iterator<StrongAgaintRanking> itS = strongAgainstRanking.iterator();
			while (itS.hasNext()){
				StrongAgaintRanking thisRanking = itS.next();
				System.out.println("             Effectiveness ranking : "
						+ thisRanking.rankingNumOfPok + ",similar to:"
						+ thisRanking.rankingNumSimilar + " factor :"
						+ thisRanking.getFactor() + " facor ranking :"
						+ thisRanking.rankingNumOfFactor);
				ArrayList<Pokemon> ps = strongAgainstPokemons.get(thisRanking);
				Iterator<Pokemon> itp = ps.iterator();
				while (itp.hasNext()){
					System.out.print(itp.next().getPrintName() + ",");					
				}
				System.out.println();
			}
		}else if ( pfs == null){
			System.out.println("Not Found : " + pokemonName);
		}
	}
	
	
	static public HashMap<Double, ArrayList<Pokemon>>  fightAll(Pokemon p1, boolean toLog) {
		
		
		TreeSet<Double> rets = null;
		HashMap<Double, ArrayList<Pokemon>> ret = null;
		
		if ( fightResults.containsKey(p1.getPrintName())){
			
			rets = fightResults.get(p1.getPrintName()).getFactors();
			ret = fightResults.get(p1.getPrintName()).getResults();
			
		} else {
		
			rets = new TreeSet<Double>();
			ret = new HashMap<Double, ArrayList<Pokemon>>();
			
			//ArrayList<Pokemon> ret = new ArrayList<Pokemon>();
			
			Iterator<PokemonTemplate> it = PokemonRegistry.pokemons.iterator();
			while (it.hasNext()) {
				PokemonTemplate pt = it.next();
	
				for (int i = 0; i < pt.getMove1().length; i++) {
					for (int j = 0; j < pt.getMove2().length; j++) {
						Pokemon newP = new Pokemon(pt.getName(), pt.getType1(),
								pt.getType2(), pt.getMove1()[i], pt.getMove2()[j]);
						double fs = comparePokemon(p1, newP);
						Double key = Double.valueOf(fs);
						rets.add(Double.valueOf(fs));					
						if ( ret.containsKey(key)){
							ret.get(key).add(newP);
						} else {
							ArrayList<Pokemon> newList = new ArrayList<Pokemon>();
							newList.add(newP);
							ret.put(key, newList);
						}
					}
				}
			}
			PokemonFightResult fRes = new PokemonFightResult(p1.getPrintName());
			fRes.setFactors(rets);
			fRes.setResults(ret);
					
			fightResults.put(p1.getPrintName(), fRes);
			
		}
		
		if ( toLog ){
			Iterator<Double> itResults = rets.iterator();
			while (itResults.hasNext()){
				Double thisValue = itResults.next();
				ArrayList<Pokemon> list = ret.get(thisValue);
				System.out.println(thisValue+ " : " + list.size());
				for ( int i = 0; i < list.size() && i < 70; i++){
					System.out.print(list.get(i).getPrintName() + ",");
				}
				System.out.println();
			}
		}

		//System.out.println(p1.getPrintName() + ":" + rets.iterator().next());
		
		return ret;
	}
	
	static public HashMap<Double, ArrayList<Pokemon>>  printDefenseStats(Pokemon p1, boolean toLog) {
		
		
		TreeSet<Double> rets = null;
		HashMap<Double, ArrayList<Pokemon>> ret = null;
		
		if ( fightResults.containsKey(p1.getPrintName())){
			
			PokemonFightResult res = fightResults.get(p1.getPrintName());
			//<tr><td>1</td><td>Snorlax</td><td>Ghost</td><td>Ground</td><td>-3.0</td><td>-1.5</td><td>PINSIR:FIGHTING,FIGHTING,URSARING:FIGHTING,FIGHTING,KANGASKHAN:FIGHTING,FIGHTING</td></tr>
			fstr.print("<tr><td>1</td><td>" + p1.getName());
			fstr.print("</td><td>" + p1.getMove1Type());
			fstr.print("</td><td>" + p1.getMove2Type()+"</td>");
			fstr.print("<td>" + res.getMostEffectiveFactor()+"</td>");
			fstr.print("<td>" + res.getnthEffectiveFactor(20)+"</td>");
			fstr.print("<td>" + res.getMostEffectiveFoes(100)+"</td>");
			fstr.println("</tr>");
			
		} else {
			System.out.println("Not Found : " + p1.getPrintName());
		}
		
		return ret;
	}
	
	static public void whichMove(String name, boolean toAttack, boolean toBeAttacked, double threshold) {
		
		ArrayList<Pokemon> ps = PokemonRegistry.getPokemons(name);
		//ArrayList<Pokemon> toCompare = new ArrayList<Pokemon>();
		TreeSet<Pokemon> toCompareSet = new TreeSet<Pokemon>();
		
		System.out.print("    ");				
		for ( int i = 0 ; i < ps.size(); i ++){
			System.out.print(ps.get(i).getPrintName() + "    ");				
			//toCompare.addAll(findMostEffective(ps.get(i), true, false, 2.6d));
			toCompareSet.addAll(findMostEffective(ps.get(i), toAttack, toBeAttacked, threshold));
		}
		System.out.println();

		Iterator<Pokemon> it = toCompareSet.iterator();
		while (it.hasNext()){
			Pokemon toCompareP = it.next();
			System.out.print(toCompareP.getPrintName() + "    ");				
			for ( int j = 0; j < ps.size(); j++ ){
				double fs = comparePokemon(ps.get(j), toCompareP);
				System.out.print( "" + fs + "      ");				
			}
			System.out.println();
		}

		return;
	}
	
	public static double comparePokemonOneWay(Pokemon p1, Pokemon p2, boolean toLog) {

		Double d11 = getFactor(p1.getMove1Type(), p2.getType1());
		Double d12 = getFactor(p1.getMove1Type(), p2.getType2());

		Double d21 = getFactor(p1.getMove2Type(), p2.getType1());
		Double d22 = getFactor(p1.getMove2Type(), p2.getType2());
		
		double ret = d11 * d12 + d21 * d22;
		
		if ( toLog){
			System.out.println("" + d11 + "," + d12 + "," + d21 + "," + d22 + "total : " + ret);
		}
		return ret;
	}

	public static double comparePokemon(Pokemon p1, Pokemon p2) {

		return comparePokemon(p1, p2, false);
	}

	public static double comparePokemonWithDetail(Pokemon p1, Pokemon p2) {

		return comparePokemon(p1, p2, true);
	}
	
	public static double comparePokemon(Pokemon p1, Pokemon p2, boolean toLog) {

		return comparePokemonOneWay(p1, p2 , toLog) - comparePokemonOneWay(p2, p1, toLog);
	}
	
	public static Double getFactor(String p1, String p2) {

		Double d12 = null;

		if (p1 != null && p2 != null && p2.length() > 0 && p1.length() > 0) {
			d12 = TypeMoveChart.factorChart.get(p1 + "_" + p2);
		}

		if (d12 == null) {
			d12 = Double.valueOf(1d);
		}
		return d12;
	}

	public static HashMap<String, PokemonFightResult> getFightResults() {
		return fightResults;
	}


}
