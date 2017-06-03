package com.patrickmonaghan.travellingsalesman.simulatedannealing;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

public class JourneyTest {

	@Test
	public void testJourneyConstructor(){
		Journey journey = new Journey();
		assertEquals(0, journey.getPoints().size());
	}
	
	@Test
	public void testJourneyCreatePoint(){
		Journey journey = new Journey();
		Point glasgow = journey.createPoint("Glasgow", 55.860888, -4.251422);
		assertEquals("Glasgow", glasgow.getName());
		assertEquals(55.860888, glasgow.getLatitude(), 0);
		assertEquals(-4.251422, glasgow.getLongitude(), 0);
		assertEquals(1, journey.getPoints().size());
	}
	
	@Test
	public void testJourneyDistance(){
		Journey journey = new Journey();
		journey.createPoint("Glasgow", 55.860888, -4.251422);
		journey.createPoint("London", 51.500946, -0.123673);
		DecimalFormat df = new DecimalFormat("###.##");
		assertEquals("555.59", df.format(journey.getDistance()));
		
		journey.createPoint("Isle of Skye", 57.250407, -6.258038);
		assertEquals("1307.63", df.format(journey.getDistance()));
	}
	
	@Test
	public void testJourneyClone(){
		Journey journey = new Journey();
		journey.createPoint("Glasgow", 55.860888, -4.251422);
		journey.createPoint("London", 51.500946, -0.123673);
		journey.createPoint("Isle of Skye", 57.250407, -6.258038);
		assertEquals(3, journey.getPoints().size());
		
		Journey journeyClone = journey.clone();
		assertEquals(3, journeyClone.getPoints().size());
		
	}

}
