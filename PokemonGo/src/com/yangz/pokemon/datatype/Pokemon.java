package com.yangz.pokemon.datatype;

import com.yangz.pokemon.data.TypeMoveChart;

public class Pokemon implements Comparable<Pokemon>{
	public Pokemon(String name, String type1, String type2, String move1Type,
			String move2Type) {
		super();
		this.type1 = type1;
		this.type2 = type2;
		this.name = name;
		this.move1Type = move1Type;
		this.move2Type = move2Type;

		TypeMoveChart.checkType(type1);
		TypeMoveChart.checkType(type2);
		TypeMoveChart.checkType(move1Type);
		TypeMoveChart.checkType(move2Type);

		this.printName = this.name + "<font color='grey'>(" + this.move1Type.toLowerCase() + ","
				+ this.move2Type.toLowerCase()+ ")</font>";
	}

	String type1;
	String type2;

	String name;

	String move1Type;
	String move2Type;

	String printName;

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

	public String getMove1Type() {
		return move1Type;
	}

	public void setMove1Type(String move1Type) {
		this.move1Type = move1Type;
	}

	public String getMove2Type() {
		return move2Type;
	}

	public void setMove2Type(String move2Type) {
		this.move2Type = move2Type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrintName() {
		return printName;
		//return printName.toUpperCase();
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}

	public int compareTo(Pokemon o) {
		// TODO Auto-generated method stub
		return this.getPrintName().compareTo(o.getPrintName());
	}

}
