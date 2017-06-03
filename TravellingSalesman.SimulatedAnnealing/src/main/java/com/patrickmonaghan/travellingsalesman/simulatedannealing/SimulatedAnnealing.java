package com.patrickmonaghan.travellingsalesman.simulatedannealing;

public class SimulatedAnnealing {

	public static Journey simulatedAnnealing(Journey journey){		
		Journey currentSolution = journey.clone();
		Journey best = currentSolution;
		
		// Set initial temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        while(temp > 1){
        	// Get a new solution
        	Journey newJourney = currentSolution.clone();
        	
        	int pos1 = (int) (newJourney.getPoints().size() * Math.random());
        	int pos2 = (int) (newJourney.getPoints().size() * Math.random());
        	
        	//Swap two points
        	newJourney.swapPoints(pos1, pos2);
        	
        	if (acceptanceProbability(currentSolution.getDistance(), newJourney.getDistance(), temp) > Math.random()) {
        		currentSolution = newJourney;
        	}
        	
        	// Keep track of the best solution found
        	if(currentSolution.getDistance() < best.getDistance()){
        		best = currentSolution;
        	}
        	
        	  // Cool system
            temp *= 1-coolingRate;
        }
        
        return best;
	}
	
	public static double acceptanceProbability(double currentDistance, double newDistance, double temperature){
		if(newDistance < currentDistance){
			// Accept if the new distance is smaller than current distance
			return 1.0d;
		} else {
			// New distance is worse, so calculate an acceptance probability
			 return Math.exp((currentDistance - newDistance) / temperature);
		}
	}
}
