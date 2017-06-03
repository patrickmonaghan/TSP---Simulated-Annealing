package com.patrickmonaghan.travellingsalesman.simulatedannealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Journey implements Cloneable{
	
	private ArrayList<Point> points;
	
	public Journey(){
		setPoints(new ArrayList<>());
	}
	
	public Point createPoint(String name, double lat, double lon){
		Point newPoint = new Point(name, lat, lon);
		addPoint(newPoint);
		return newPoint;
	}
	
	public void addPoint(Point point){
		this.points.add(point);
	}
	
	public List<Point> getPoints(){
		return this.points;
	}
	
	public void setPoints(ArrayList<Point> points){
		this.points = points;
	}
	
	public double getDistance(){
		double distance = 0.0d;
		Point prevPoint = null;
		for(Point point : getPoints()){
			if(prevPoint != null){
				distance += prevPoint.distanceTo(point);
				prevPoint = point;
			} else {
				prevPoint = point;
			}
		}
		return distance;
	}
	
	public Point getPoint(Integer position){
		return getPoints().get(position);
	}
	
	public void swapPoints(Integer oldPosition, Integer newPosition){
		Collections.swap(this.points, oldPosition, newPosition);
	}
	
	@Override
	public Journey clone(){
		Journey journey = new Journey();
		ArrayList<Point> clone = new ArrayList<>();
		getPoints().forEach(point -> clone.add(point.clone()));
		journey.setPoints(clone);
		return journey;
		
	}
	
	public String getPointNames(){
		return this.getPoints()
				.stream()
				.map(point->point.getName())
				.collect(Collectors.joining (" -> "));
	}
	
	
	

}
