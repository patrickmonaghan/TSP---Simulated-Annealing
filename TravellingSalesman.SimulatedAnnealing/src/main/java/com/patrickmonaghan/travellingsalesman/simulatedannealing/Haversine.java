package com.patrickmonaghan.travellingsalesman.simulatedannealing;

/**
 * This class provides functions that calculates the distance between two points using the Haversine function. <br />
 * @author patrickmonaghan
 * @see <a href="http://www.movable-type.co.uk/scripts/latlong.html">http://www.movable-type.co.uk/scripts/latlong.html</a> for calculation details
 */
public class Haversine {
	
	private static final int EARTH_RADIUS_KM = 6371; 
	
	/**
	 * Calculates the distance between two points
	 * @param point1 {@link Point}
	 * @param point2 {@link Point}
	 * @return Distance (in KM) between two points
	 */
	public static double calculateDistance(Point point1, Point point2){
		double phi1 = Math.toRadians(point1.getLatitude());
		double phi2 = Math.toRadians(point2.getLatitude());
		double deltaPhi = Math.toRadians(point2.getLatitude() - point1.getLatitude());
		double deltaLambda = Math.toRadians(point2.getLongitude() - point1.getLongitude());
		double a = haversineSin(deltaPhi) + Math.cos(phi1) * Math.cos(phi2) * haversineSin(deltaLambda);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return EARTH_RADIUS_KM * c;
	}
	
	/**
	 * The Haversine function calls for the Sin of deltaPhi/2 to be squared: Math.sin(Δφ/2) * Math.sin(Δφ/2)
	 * This function just tidies that up a bit in the calcuulation
	 * @param value deltaPhi value
	 * @return (deltaPhi/2)^2
	 */
	private static double haversineSin(Double value){
		return Math.pow(Math.sin(value/2), 2);
	}

}
