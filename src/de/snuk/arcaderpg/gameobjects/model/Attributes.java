package de.snuk.arcaderpg.gameobjects.model;

public class Attributes {

	private int hp;
	private int mp;
	private int strength;
	private int intelligence;
	private int dexterity;
	private int vitality;
	
	private int crit_damage;
	private double crit_chance;
	
	
	public Attributes(){
		
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getMp() {
		return mp;
	}


	public void setMp(int mp) {
		this.mp = mp;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getDexterity() {
		return dexterity;
	}


	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}


	public int getVitality() {
		return vitality;
	}


	public void setVitality(int vitality) {
		this.vitality = vitality;
	}


	public int getCrit_damage() {
		return crit_damage;
	}


	public void setCrit_damage(int crit_damage) {
		this.crit_damage = crit_damage;
	}


	public double getCrit_chance() {
		return crit_chance;
	}


	public void setCrit_chance(double crit_chance) {
		this.crit_chance = crit_chance;
	}
}
