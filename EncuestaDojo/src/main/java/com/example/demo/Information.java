package com.example.demo;

public class Information {

	String name;
	String location;
	String language;
	String comment;
	
	public Information(String name, String location, String language, String comment) {
		this.name = name;
		this.location = location;
		this.language = language;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void result() {
		System.out.println(this.name);
		System.out.println(this.location);
		System.out.println(this.language);
		System.out.println(this.comment);
	}
	
}
