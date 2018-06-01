package com.revature.beans;

public class Superhero {
	private int heroID;
	private String heroName;
	public Superhero(int heroID, String heroName) {
		super();
		this.heroID = heroID;
		this.heroName = heroName;
	}
	public int getHeroID() {
		return heroID;
	}
	public void setHeroID(int heroID) {
		this.heroID = heroID;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	@Override
	public String toString() {
		return "Superhero [heroID=" + heroID + ", heroName=" + heroName + "]";
	}
	
}
