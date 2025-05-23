package com.ui.pojo;

public class Environment {

	private String url;
	
	private int Max_NUMBER_OF_ATTEMPTS;

	public int getMax_NUMBER_OF_ATTEMPTS() {
		return Max_NUMBER_OF_ATTEMPTS;
	}

	public Environment(String url, int max_NUMBER_OF_ATTEMPTS) {
		super();
		this.url = url;
		Max_NUMBER_OF_ATTEMPTS = max_NUMBER_OF_ATTEMPTS;
	}

	public void setMax_NUMBER_OF_ATTEMPTS(int max_NUMBER_OF_ATTEMPTS) {
		Max_NUMBER_OF_ATTEMPTS = max_NUMBER_OF_ATTEMPTS;
	}

	public Environment(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Environment [url=" + url + "]";
	}
	
	
}
