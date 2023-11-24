package com.sentuh.jokesapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class JokesItem {
	@SerializedName("icon_url")
	private String iconUrl;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("categories")
	private List<Object> categories;

	@SerializedName("id")
	private String id;

	@SerializedName("value")
	private String value;

	@SerializedName("url")
	private String url;

	public String getIconUrl(){
		return iconUrl;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public List<Object> getCategories(){
		return categories;
	}

	public String getId(){
		return id;
	}

	public String getValue(){
		return value;
	}

	public String getUrl(){
		return url;
	}
}