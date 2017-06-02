package com.patrickmonaghan.travellingsalesman.simulatedannealing;

/**
 * Models a point
 * @author Patrick Monaghan
 */
public class Point {
	
	private double lat;
	private double lon;
	
	/**
	 * Constructor
	 * @param lat Latitude of new point
	 * @param lon Longitude of new point
	 */
	public Point(double lat, double lon){
		setLatitude(lat);
		setLongitude(lon);
	}
	
	/**
	 * Calculates the distance between two points
	 * @param point Other {@link Point}
	 * @return distance between two points
	 */
	public double distanceTo(Point point){
		return Haversine.calculateDistance(this, point);
	}

	/**
	 * Retrieve the latitude
	 * @return Latitude
	 */
	public double getLatitude() {
		return lat;
	}

	/**
	 * Set the latitude
	 * @param lat New latitude value
	 */
	public void setLatitude(double lat) {
		this.lat = lat;
	}

	/**
	 * Retrieve the longitude
	 * @return Longitude
	 */
	public double getLongitude() {
		return lon;
	}

	/**
	 * Set the longitude
	 * @param lon Longitude
	 */
	public void setLongitude(double lon) {
		this.lon = lon;
	}
	
	
}
