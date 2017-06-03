package com.patrickmonaghan.travellingsalesman.simulatedannealing;

public class Main {

	public static void main(String[] args) {
		Journey journey = new Journey();
		journey.createPoint("Glasgow", 55.860888, -4.251422);
		journey.createPoint("London", 51.500946, -0.123673);
		journey.createPoint("Isle of Skye", 57.250407, -6.258038);
		journey.createPoint("Manchester", 53.476210, -2.250881);
		journey.createPoint("Windemere", 54.363425, -2.922059);
		
		System.out.println("Current solution: " + journey.getDistance());
		System.out.println("\t" + journey.getPointNames());
		Journey newJourney = SimulatedAnnealing.simulatedAnnealing(journey);
		
		System.out.println("New solution: " + newJourney.getDistance());
		System.out.println("\t" + newJourney.getPointNames());
	}

}
