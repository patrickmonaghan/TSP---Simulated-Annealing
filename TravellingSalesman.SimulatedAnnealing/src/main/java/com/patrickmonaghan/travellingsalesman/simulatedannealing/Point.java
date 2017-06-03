package com.patrickmonaghan.travellingsalesman.simulatedannealing;

/**
 * Models a point
 * @author Patrick Monaghan
 */
public class Point implements Cloneable{
	
	private String name;
	private double lat;
	private double lon;
	
	/**
	 * Constructor
	 * @param lat Latitude of new point
	 * @param lon Longitude of new point
	 */
	public Point(String name, double lat, double lon){
		setName(name);
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
	 * Retrieve the name of the point
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name
	 * @param name New name value
	 */
	public void setName(String name) {
		this.name = name;
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
	
	@Override
	public Point clone(){
		Point p = new Point(this.getName(), this.getLatitude(), this.getLongitude());
		return p;
	}
	
	
	
	
}
