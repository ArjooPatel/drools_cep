package com.cognizant.cep.sherlock;

import java.io.FileNotFoundException;
import java.util.List;

import org.testng.annotations.Test;

import com.cognizant.cep.sherloack.Impl.SherlockEventProcessingImpl;
import com.cognizant.cep.sherloack.data.SherlockDataLoder;
import com.cognizant.cep.sherlock.model.SherlockEvent;


public class TestSherlockApp {
	
	@Test(priority = 0)
	public void TestRuleEngine1() throws FileNotFoundException {
		String filePath="src\\main\\resources\\FORWARD.drl";
		SherlockEventProcessingImpl eventProcessingImpl = new SherlockEventProcessingImpl();
		List<SherlockEvent> events= SherlockDataLoder.getSherlockEvents();
		eventProcessingImpl.process(events, filePath);
		
	}
	
	
	@Test(priority = 1)
	public void TestSherlockApp1() throws FileNotFoundException {
		String filePath="src\\main\\resources\\FORWARD.drl";
		SherlockEventProcessingImpl eventProcessingImpl = new SherlockEventProcessingImpl();
		List<SherlockEvent> events= SherlockDataLoder.getSherlockEventsForFailedEvent();
		eventProcessingImpl.process(events, filePath);
		
	}

}
