package com.yangz.pokemon.datatype;

public class PokemonTemplate {

	public PokemonTemplate(String name, int cp, int hp, String type1, String type2,
			String[] move1, String[] move2) {
		super();
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.move1 = move1;
		this.move2 = move2;
		this.CP = cp;
		this.HP = hp;
	}
	private String name;
	private String type1;
	private String type2 = null;
	private String[] move1 = null;
	private String[] move2 = null;
	private int CP;
	private int HP;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String[] getMove1() {
		return move1;
	}
	public void setMove1(String[] move1) {
		this.move1 = move1;
	}
	public String[] getMove2() {
		return move2;
	}
	public void setMove2(String[] move2) {
		this.move2 = move2;
	}
	public int getCP() {
		return CP;
	}
	public void setCP(int cP) {
		CP = cP;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	
	
}
