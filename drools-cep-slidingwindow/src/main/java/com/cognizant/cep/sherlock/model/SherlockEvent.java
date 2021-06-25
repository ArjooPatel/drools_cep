package com.cognizant.cep.sherlock.model;


public class SherlockEvent {
	
	private int eventId;
	private String eventType;
	private String eventDescription;
	private String eventSourceIp;
	private String eventDestinationIp;
	private String eventSourcePort;
	private String eventDestinationPort;
	private String eventSourceCountry;
	private String eventDestinationCountry;
	private String eventSourceUsername;
	private String eventDestinationUsername;
	private String eventRemarks;
	private long eventSourceTime;
	private long eventDestinationTimestamp;
	
	public int getEventId() {
		return eventId;
	}
	
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}
	
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	public String getEventSourceIp() {
		return eventSourceIp;
	}
	
	public void setEventSourceIp(String eventSourceIp) {
		this.eventSourceIp = eventSourceIp;
	}
	
	public String getEventDestinationIp() {
		return eventDestinationIp;
	}
	
	public void setEventDestinationIp(String eventDestinationIp) {
		this.eventDestinationIp = eventDestinationIp;
	}
	
	public String getEventSourcePort() {
		return eventSourcePort;
	}
	
	public void setEventSourcePort(String eventSourcePort) {
		this.eventSourcePort = eventSourcePort;
	}
	
	public String getEventDestinationPort() {
		return eventDestinationPort;
	}
	
	public void setEventDestinationPort(String eventDestinationPort) {
		this.eventDestinationPort = eventDestinationPort;
	}
	
	public String getEventSourceCountry() {
		return eventSourceCountry;
	}
	
	public void setEventSourceCountry(String eventSourceCountry) {
		this.eventSourceCountry = eventSourceCountry;
	}
	
	public String getEventDestinationCountry() {
		return eventDestinationCountry;
	}
	
	public void setEventDestinationCountry(String eventDestinationCountry) {
		this.eventDestinationCountry = eventDestinationCountry;
	}
	
	public String getEventSourceUsername() {
		return eventSourceUsername;
	}
	
	public void setEventSourceUsername(String eventSourceUsername) {
		this.eventSourceUsername = eventSourceUsername;
	}
	
	public String getEventDestinationUsername() {
		return eventDestinationUsername;
	}
	
	public void setEventDestinationUsername(String eventDestinationUsername) {
		this.eventDestinationUsername = eventDestinationUsername;
	}
	
	public String getEventRemarks() {
		return eventRemarks;
	}
	
	public void setEventRemarks(String eventRemarks) {
		this.eventRemarks = eventRemarks;
	}
	
	public long getEventSourceTime() {
		return eventSourceTime;
	}
	
	public void setEventSourceTime(long eventSourceTime) {
		this.eventSourceTime = eventSourceTime;
	}
	
	public long getEventDestinationTimestamp() {
		return eventDestinationTimestamp;
	}

	public void setEventDestinationTimestamp(long eventDestinationTimestamp) {
		this.eventDestinationTimestamp = eventDestinationTimestamp;
	}

	@Override
	public String toString() {
		return "SherlockEvent [eventId=" + eventId + ", eventType=" + eventType + ", eventDescription="
				+ eventDescription + ", eventSourceIp=" + eventSourceIp + ", eventDestinationIp=" + eventDestinationIp
				+ ", eventSourcePort=" + eventSourcePort + ", eventDestinationPort=" + eventDestinationPort
				+ ", eventSourceCountry=" + eventSourceCountry + ", eventDestinationCountry=" + eventDestinationCountry
				+ ", eventSourceUsername=" + eventSourceUsername + ", eventDestinationUsername="
				+ eventDestinationUsername + ", eventRemarks=" + eventRemarks + ", eventSourceTime=" + eventSourceTime
				+ ", eventDestinationTimestamp=" + eventDestinationTimestamp + "]";
	}
	
	
}
