package com.yangz.pokemon;

public class StrongAgaintRanking implements Comparable<StrongAgaintRanking>{
	
	public StrongAgaintRanking(String srcPokemon, String againstPokemon, Double factor,
			int rankingNumOfFactor, int rankingNumOfPok, int rankingNumSimilar) {
		super();
		this.factor = factor;
		this.srcPokemon = srcPokemon;
		this.againstPokemon = againstPokemon;
		this.rankingNumOfPok = rankingNumOfPok;
		this.rankingNumOfFactor = rankingNumOfFactor;
		this.rankingNumSimilar = rankingNumSimilar;
	}
	
	public StrongAgaintRanking() {
		super();
	}
	
	String srcPokemon;
	String againstPokemon;
	Double factor;
	int rankingNumOfFactor;
	int rankingNumOfPok;
	int rankingNumSimilar;
	public String getSrcPokemon() {
		return srcPokemon;
	}
	public void setSrcPokemon(String srcPokemon) {
		this.srcPokemon = srcPokemon;
	}
	public String getAgainstPokemon() {
		return againstPokemon;
	}
	public void setAgainstPokemon(String againstPokemon) {
		this.againstPokemon = againstPokemon;
	}
	public int getRankingNumOfPok() {
		return rankingNumOfPok;
	}
	public void setRankingNumOfPok(int rankingNumOfPok) {
		this.rankingNumOfPok = rankingNumOfPok;
	}
	public int getRankingNumOfFactor() {
		return rankingNumOfFactor;
	}
	public void setRankingNumOfFactor(int rankingNumOfFactor) {
		this.rankingNumOfFactor = rankingNumOfFactor;
	}
	public int getRankingNumSimilar() {
		return rankingNumSimilar;
	}
	public void setRankingNumSimilar(int rankingNumSimilar) {
		this.rankingNumSimilar = rankingNumSimilar;
	}

	public int compareTo(StrongAgaintRanking inRanking) {
		// TODO Auto-generated method stub
		int ret;
		
		ret = inRanking.rankingNumOfPok - this.rankingNumOfPok ;
		
		if ( ret == 0){
			ret = inRanking.rankingNumSimilar - this.rankingNumSimilar ;
		} 
		
		if ( ret == 0){
			ret = inRanking.rankingNumOfFactor - this.rankingNumOfFactor;
		} 
		
		if ( ret == 0){
			ret = this.factor.compareTo(inRanking.getFactor());
		} 
		
		return ret;
	}

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}
}
