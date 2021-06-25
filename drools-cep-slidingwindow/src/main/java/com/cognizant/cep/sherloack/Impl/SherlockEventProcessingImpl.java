package com.cognizant.cep.sherloack.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;

import com.cognizant.cep.sherlock.model.SherlockEvent;
import com.cognizant.cep.sherlock.model.SherlockEventCorrelation;

public class SherlockEventProcessingImpl {
	
	// Drools Fusion Runtime Configuration
		private KieBaseConfiguration kieConfiguration;
		private KieServices ks;
		private KieBase kieBase;
		private KieContainer kContainer;
		private KieSession kSession;
		private KnowledgeBuilder kbuilder;

		// memory sizing and reporting activities
		static long totalFactCount = 0;
	
	
	public void process(List<SherlockEvent> events, String filepath) {
		
		
		try {
			System.out.println("Sherlock Complex Event Processing is Testing Standalone...");

			System.setProperty("drools.dialect.mvel.strict", "false");
			System.setProperty("org.kie.demo", "false");

			System.out.println("Sherlock Complex Event Processing - Test Standalone Events");
			System.out.println("==========================================================");

			System.out.println("Initializing KIE Runtime for Drools Fusion...");

			kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			// kbuilder.add(ResourceFactory.newClassPathResource("event.drl"),
			// ResourceType.DRL);

			if (kbuilder.hasErrors()) {
				System.out.println(kbuilder.getErrors().toString());
			}

			kieConfiguration = KieServices.Factory.get().newKieBaseConfiguration();
			kieConfiguration.setOption(EventProcessingOption.STREAM);
			ks = KieServices.Factory.get();
			kContainer = ks.getKieClasspathContainer();
			kieBase = KnowledgeBaseFactory.newKnowledgeBase(kieConfiguration);


			// clock type for the session
			KieSessionConfiguration sessionConfiguration = KnowledgeBaseFactory.newKnowledgeSessionConfiguration();
			sessionConfiguration.setOption(ClockTypeOption.get("realtime"));

			kSession = kContainer.newKieSession("sherlock-event", sessionConfiguration);
			kSession.setGlobal("threatMap", new HashMap<Long, SherlockEventCorrelation>());
			System.out.println("Initialized the KIE Runtime for Drools Fusion...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	for(SherlockEvent event: events) {
		execute(event);
	}
	}
	


	public void execute(SherlockEvent event) {

System.out.println(event.toString());
		kSession.insert(event);
		
			kSession.fireAllRules();

	}

}
