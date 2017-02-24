package com.fastsprings.model;

import java.io.Serializable;

public class AccessToken implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String clientId;
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	private String clientSecretKey;
	
	private String accessToken;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecretKey() {
		return clientSecretKey;
	}

	public void setClientSecretKey(String clientSecretKey) {
		this.clientSecretKey = clientSecretKey;
	}

}
