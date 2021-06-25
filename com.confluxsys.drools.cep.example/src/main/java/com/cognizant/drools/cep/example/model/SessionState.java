package com.cognizant.drools.cep.example.model;

public class SessionState {

	private String sessionId;
	private String state;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "SessionState [sessionId=" + sessionId + ", state=" + state + "]";
	}

	
}
