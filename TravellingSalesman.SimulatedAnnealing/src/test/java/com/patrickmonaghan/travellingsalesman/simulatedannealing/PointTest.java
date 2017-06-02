package com.patrickmonaghan.travellingsalesman.simulatedannealing;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

public class PointTest {

	@Test
	public void testConstructor() {
		Point glasgow = new Point(55.860888, -4.251422);
		assertEquals(55.860888, glasgow.getLatitude(), 0);
		assertEquals(-4.251422, glasgow.getLongitude(), 0);
	}
	
	@Test
	public void testDistanceCalculation() {
		Point glasgow = new Point(55.860888, -4.251422);
		Point london = new Point(51.500946, -0.123673);
		DecimalFormat df = new DecimalFormat("###.##");
		assertEquals("555.59", df.format(glasgow.distanceTo(london)));
	}

}
