package com.patrickmonaghan.travellingsalesman.simulatedannealing;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimulatedAnnealingTest {

	@Test
	public void testSA() {
		Journey journey = new Journey();
		journey.createPoint("Glasgow", 55.860888, -4.251422);
		journey.createPoint("London", 51.500946, -0.123673);
		journey.createPoint("Isle of Skye", 57.250407, -6.258038);
		journey.createPoint("Manchester", 53.476210, -2.250881);
		journey.createPoint("Windemere", 54.363425, -2.922059);
		
		assertEquals(1905.605635783496, journey.getDistance(), 0);
		Journey newJourney = SimulatedAnnealing.simulatedAnnealing(journey);
		assertEquals(754.8157052498457, newJourney.getDistance(), 0);
	}

}
