package net.gluck.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

/*
 * @author John Gluck
 * 
 * @date 03/08/2016
 * 
 * @description This is basically a DTO
 */
public class Movie {

	public Movie() {
	}

	// TODO: There are a few ways this can go wrong. It needs to be urlEncoded
	// and stripped
	// of special characters. There's not much defensive coding here.

	public Movie(String name, String imageUrl, String rating, String description) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String imageUrl;
	private String rating;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
