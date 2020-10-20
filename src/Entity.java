package com.gamingroom;

//creates class with variables
public class Entity {
	long id;
	String name;

	// Hide the default constructor Entity to prevent creating empty instances.
	private Entity() {

	}

	// constructor and initialized variables
	Entity(long id, String name) {
		this(); // call default constructor
		this.id = id;
		this.name = name;
	}

	// method to get and return id value
	public long getId() {
		return id;
	}

	// method to get name and return name value
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]"; //needed to change return statement from Game to Entity so the correct string was returned
	}

}
