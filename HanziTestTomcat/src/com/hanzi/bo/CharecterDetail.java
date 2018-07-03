package com.hanzi.bo;

public class CharecterDetail {

	public CharecterDetail(char charecter, String pinyin, int status) {
		super();
		this.charecter = charecter;
		this.pinyin = pinyin;
		this.status = status;
	}
	
	private char charecter;
	private String pinyin;
	private int status; // -1 new, 1 read, 2 write 
	
	public char getCharecter() {
		return charecter;
	}
	public void setCharecter(char charecter) {
		this.charecter = charecter;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String toString() {
		return "" + charecter + "," + pinyin + "," + status;
	}
}
