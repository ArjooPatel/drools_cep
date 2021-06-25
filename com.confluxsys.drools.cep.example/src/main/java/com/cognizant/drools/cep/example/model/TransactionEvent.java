package com.cognizant.drools.cep.example.model;

public class TransactionEvent {

	private final String sessionId;
	private final String pageCategory;

	public TransactionEvent(String sessionId, String pageCategory) {
		super();
		this.sessionId = sessionId;
		this.pageCategory = pageCategory;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getPageCategory() {
		return pageCategory;
	}

	@Override
	public String toString() {
		return "TransactionEvent [sessionId=" + sessionId + ", pageCategory=" + pageCategory + "]";
	}

}
