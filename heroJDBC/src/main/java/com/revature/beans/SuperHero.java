package com.revature.beans;

public class SuperHero {
	private int heroId;
	private String heroName;
	
	
	public String getHerName() {
		return heroName;
	}
	public void setHerName(String heroName) {
		this.heroName = heroName;
	}
	public int getHeroId() {
		return heroId;
	}
	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}
	
	
	public SuperHero(int heroId, String heroName) {
		super();
		this.heroId = heroId;
		this.heroName = heroName;
	}
	
	public SuperHero() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SuperHero [heroId=" + heroId + ", heroName=" + heroName + "]";
	}
	
	
	

}
