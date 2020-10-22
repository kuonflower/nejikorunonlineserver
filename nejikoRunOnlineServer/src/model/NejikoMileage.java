package model;

import java.io.Serializable;

public class NejikoMileage implements Serializable {

	private String name;
	private int score;
	public NejikoMileage(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public NejikoMileage() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}



}
