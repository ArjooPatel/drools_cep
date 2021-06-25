package com.cognizant.drools.cep.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.drools.cep.example.model.TransactionEvent;


/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger logger =  LoggerFactory.getLogger(App.class);
	private static final String IN_MEMORY_DRL_FILE = "src/main/resources/InMemoryDrl.drl";
	private static final String DRL_FILE = "src/main/resources/rules/droolsrules.drl";

    public static void main( String[] args ) throws FileNotFoundException
    {

    	logger.trace("Initializing rule engine...");
		KieBase kieBase = null;
		KieSession kSession = null;
		logger.debug("creating new Kie Base...");
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kfs = kieServices.newKieFileSystem();
		FileInputStream ruleFile = new FileInputStream(DRL_FILE);
		kfs.write(IN_MEMORY_DRL_FILE,
				kieServices.getResources().newInputStreamResource(ruleFile).setResourceType(ResourceType.DRL));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
		if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
			logger.error(kieBuilder.getResults().toString());
		}
		KieContainer kContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
		KieBaseConfiguration kbconf = kieServices.newKieBaseConfiguration();
		kbconf.setOption(EventProcessingOption.STREAM);
		kieBase = kContainer.newKieBase(kbconf);
		kSession = kieBase.newKieSession();
		 List<TransactionEvent> events= loadEvents();
		for(TransactionEvent event:events) {
			kSession.insert(event);
		}

		Collection<FactHandle> factshandler = kSession.getFactHandles();
		for (FactHandle factHand : factshandler) {
			logger.info("fact : {}", factHand);
		}
		logger.info("inserted facts : {}", factshandler);
		logger.debug("facts inserted successfully...");
		logger.debug("Firing all the rules in the rule engine");
		int ruleFired = kSession.fireAllRules();
		logger.debug("rule fired : {}", ruleFired);
		kSession.dispose();
		logger.debug("Rule evaluation session disposed..");
		logger.debug("Exiting ::RuleEngineImpl.evaluate( )......");
		
	
    }
    
  
    
   public static List<TransactionEvent> loadEvents(){
	   List<TransactionEvent> events= new ArrayList<>();
	   TransactionEvent event = new TransactionEvent("1", "photo");
	   events.add(event);
		return events;}

}
