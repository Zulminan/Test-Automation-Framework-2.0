package com.ui.pojo;

import java.util.Map;

public class Config {

	private Map<String,Environment> environments;

	public Config(Map<String, Environment> environments) {
		super();
		this.environments = environments;
	}

	public Map<String, Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String, Environment> environments) {
		this.environments = environments;
	}

	@Override
	public String toString() {
		return "Config [environments=" + environments + "]";
	}
	
	

	
}
