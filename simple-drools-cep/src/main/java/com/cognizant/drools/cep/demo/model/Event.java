package com.cognizant.drools.cep.demo.model;

import java.util.Date;


public interface Event extends Fact {
	
	public abstract Date getTimestamp();

}
