package com.cognizant.cep.sherloack.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.cep.sherlock.model.SherlockEvent;

public class SherlockDataLoder {

	public static List<SherlockEvent> getSherlockEvents() {
		List<SherlockEvent> events = new ArrayList<>();
		SherlockEvent sherlockEvent = null;

		String[] actions = new String[] { "", "failed login attempt", "port and ip scan", "download log file",
				"attempt to access", "attempt to attack", "port access", "download log file2", "attempt to access2",
				"attempt to attack2" };
		int k = 0;

		while (true) {
			int v = 100, s = 0;
			if (k % 2 == 0) {
				v = 255;
			}

			// 100 / 10s
			for (int i = 0; i <= 11; i++) {
				if (s > 25)
					s = 0;
				int a = (int) (Math.random() * 10);
				if (k % 2 == 0)
					a = 1;
				sherlockEvent = new SherlockEvent();
				sherlockEvent.setEventId(i+1);
				sherlockEvent.setEventSourceIp("10.56.112.122");
				sherlockEvent.setEventDestinationIp("192.22.23.121");
				sherlockEvent.setEventSourcePort("201");
				sherlockEvent.setEventSourceTime(new java.util.Date().getTime());
				sherlockEvent.setEventDestinationPort("" + (++s));
				sherlockEvent.setEventType(actions[2]);
				sherlockEvent.setEventDestinationTimestamp(new Date().getTime());
				events.add(sherlockEvent);
			}
			k++;
			return events;

		}

	}
	
	public static List<SherlockEvent> getSherlockEventsForFailedEvent() {
		List<SherlockEvent> events = new ArrayList<>();
		SherlockEvent sherlockEvent =  new SherlockEvent();
		sherlockEvent.setEventId(1);
		sherlockEvent.setEventSourceIp("10.56.112.122");
		sherlockEvent.setEventSourcePort("201");
		sherlockEvent.setEventType("failed login attempt");
		events.add(sherlockEvent);
		
		SherlockEvent sherlockEvent1 =  new SherlockEvent();
		sherlockEvent1.setEventId(2);
		sherlockEvent1.setEventSourceIp("10.56.112.122");
		sherlockEvent1.setEventSourcePort("201");
		sherlockEvent1.setEventType("failed login attempt");
		events.add(sherlockEvent1);
		
		SherlockEvent sherlockEvent2 =  new SherlockEvent();
		sherlockEvent2.setEventId(3);
		sherlockEvent2.setEventSourceIp("10.56.112.122");
		sherlockEvent2.setEventSourcePort("201");
		sherlockEvent2.setEventType("failed login attempt");
		events.add(sherlockEvent2);
		
		SherlockEvent sherlockEvent3 =  new SherlockEvent();
		sherlockEvent3.setEventId(4);
		sherlockEvent3.setEventSourceIp("10.56.112.122");
		sherlockEvent3.setEventSourcePort("201");
		sherlockEvent3.setEventType("failed login attempt");
		events.add(sherlockEvent3);
		
		SherlockEvent sherlockEvent4 =  new SherlockEvent();
		sherlockEvent4.setEventId(5);
		sherlockEvent4.setEventSourceIp("10.56.112.122");
		sherlockEvent4.setEventSourcePort("201");
		sherlockEvent4.setEventType("failed login attempt");
		events.add(sherlockEvent4);
		
		SherlockEvent sherlockEvent5 =  new SherlockEvent();
		sherlockEvent5.setEventId(5);
		sherlockEvent5.setEventSourceIp("10.56.112.123");
		sherlockEvent5.setEventSourcePort("201");
		sherlockEvent5.setEventType("failed login attempt");
		events.add(sherlockEvent5);
		
		return events;}
	
}
