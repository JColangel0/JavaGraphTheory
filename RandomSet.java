/*
 * Written by Joseph Colangelo
 *  First version 2/17/23
 *  Current version 2/23/23
 * Graph Theory Location Nodes Project
 *  RandomSet Class 
 *      Generates random set of LocationNodes
 *      of set size
 */

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class RandomSet {
    Random random = new Random();
    int xBOUND = 50;
    int yBOUND = 50;
    int numberOfNodes;

    public RandomSet(int nodeCount) {
        this.numberOfNodes = nodeCount;
    }

    int generateNumbers(int bound) {
        // Creates random numbers either positive or negative
        int num = random.nextInt(bound);
        boolean pos = random.nextBoolean();
        num = pos ? num : num * -1;
        return num;
    }

    List<LocationNode> generateLocations() {
        // generates a list of random locations and turns them into location nodes
        // node identifier is number of nodes already existing
        List<LocationNode> locList = new ArrayList<LocationNode>();
        for (int i = 0; i < numberOfNodes; i++) {
            int xcoord = generateNumbers(xBOUND);
            int ycoord = generateNumbers(yBOUND);
            LocationNode loc = new LocationNode(new Location(xcoord, ycoord), i);
            locList.add(loc);
        }
        return locList;
    }

    List<LocationNode> generateNodes() {
        List<LocationNode> locationList = generateLocations();
        for (int i = 0; i < locationList.size(); i++) {
            locationList.get(i).createConnections(locationList, random.nextInt(3) + 2);
        }
        return locationList;
    }
}
