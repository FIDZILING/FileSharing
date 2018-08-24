package com.beans;

public class FileInfo {
	private int id;
	private String name;
	private String creator;
	private String description;
	private int downloadTimes;

	public FileInfo() {
	}

	public FileInfo(int id, String name, String creator, String description, int downloadTimes) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.description = description;
		this.downloadTimes = downloadTimes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}
}
