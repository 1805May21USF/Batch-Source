package com.revature.beans;

public class SuperHero {
	private int HeroID;
	private String HeroName;


	protected SuperHero() {
		super();
	}

	public SuperHero(int heroID, String heroName) {
		super();
		HeroID = heroID;
		HeroName = heroName;
	}

	protected int getHeroID() {
		return HeroID;
	}

	protected void setHeroID(int heroID) {
		HeroID = heroID;
	}

	protected String getHeroName() {
		return HeroName;
	}

	protected void setHeroName(String heroName) {
		HeroName = heroName;
	}
}
