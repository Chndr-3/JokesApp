package com.sentuh.jokesapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Jokes{

	@SerializedName("result")
	private List<JokesItem> result;

	@SerializedName("total")
	private int total;

	public List<JokesItem> getResult(){
		return result;
	}

	public int getTotal(){
		return total;
	}
}