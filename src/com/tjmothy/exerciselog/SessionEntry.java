package com.tjmothy.exerciselog;

public class SessionEntry
{
	private long id;
	private String name;
	private int weight;
	private int reps;

	// Getter methods
	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public int getWeight()
	{
		return weight;
	}

	public int getReps()
	{
		return reps;
	}

	// Setter methods
	public void setId(long id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public void setReps(int reps)
	{
		this.reps = reps;
	}

	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString()
	{
		return name;
	}
}
