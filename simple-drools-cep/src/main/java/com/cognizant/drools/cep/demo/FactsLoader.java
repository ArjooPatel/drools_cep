package com.cognizant.drools.cep.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.drools.cep.demo.model.BagScannedEvent;
import com.cognizant.drools.cep.demo.model.BagTag;
import com.cognizant.drools.cep.demo.model.Event;
import com.cognizant.drools.cep.demo.model.Fact;
import com.cognizant.drools.cep.demo.model.Location;


public class FactsLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(FactsLoader.class);

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd:HHmmssSSS");
	
	public static List<Event> loadEvents(File eventsFile) {

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(eventsFile));
		} catch (FileNotFoundException fnfe) {
			String message = "File not found.";
			LOGGER.error(message, fnfe);
			throw new IllegalArgumentException(message, fnfe);
		}
		return loadEvents(br);
		
	}
	
	public static List<Event> loadEvents(InputStream eventsInputStream) {
		BufferedReader br = new BufferedReader(new InputStreamReader(eventsInputStream));
		return loadEvents(br);
		
	}
	
	private static List<Event> loadEvents(BufferedReader reader) {
		List<Event> eventList = new ArrayList<Event>();
		try {
			String nextLine;
			while ((nextLine = reader.readLine()) != null) {
				if (!nextLine.startsWith("#")) {
					Event bagScanEvent = readEvent(nextLine);
					if (bagScanEvent != null) {
						eventList.add(bagScanEvent);
					}
				}
			}
		} catch (IOException ioe) {
			throw new RuntimeException("Got an IO exception while reading events.", ioe);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {
					// Swallowing exception, not much we can do here.
					LOGGER.error("Unable to close reader.", ioe);
				}
			}
		}
		return eventList;
	}

	/**
	 * Layout of a StockTick line has to be {uuid}, {timestamp}, {symbol}, {price}.
	 * 
	 * @param line
	 *            the line to parse.
	 * @return the {@link Fact}
	 */
	private static Event readEvent(String line) {
		String[] eventData = line.split(",");
		if (eventData.length != 4) {
			LOGGER.error("Unable to parse string: " + line);
		}
		Event event = null;
		try {
			BagTag tag = new BagTag(eventData[1].trim());
			event = new BagScannedEvent(eventData[0], tag, Location.valueOf(eventData[2].trim()), DATE_FORMAT.parse(eventData[3].trim()));
			
		} catch (NumberFormatException nfe) {
			LOGGER.error("Error parsing line: " + line, nfe);
		} catch (ParseException pe) {
			LOGGER.error("Error parsing line: " + line, pe);
		}
		return event;

	}

}
