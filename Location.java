/*
 * Written by Joseph Colangelo
 *  First version 2/17/23
 *  Current version 2/18/23
 * Graph Theory Location Nodes Project
 *  Location and LocationNode Classes
 *      Defines Location objects and node 
 *      information in a container class
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Location {
    // Location class - container for x and y coordinate
    double xcoord;
    double ycoord;

    public Location(double x, double y) {
        // Class constructor
        this.xcoord = x;
        this.ycoord = y;
    }

    double getX() {
        return xcoord;
    }

    double getY() {
        return ycoord;
    }

    void setX(double x) {
        xcoord = x;
    }

    void setY(double y) {
        ycoord = y;
    }

    String getStringLocation() {
        // Debugging test method
        return ("<" + xcoord + "> , <" + ycoord + ">");
    }
}

class LocationNode {
    Random random = new Random();

    Location location;
    int nodeIdentifier;
    List<LocationNode> connected; // all nodes this node is connected to

    public LocationNode(Location loc, int id) {
        // Class constructor
        this.location = loc;
        this.nodeIdentifier = id;
    }

    int getID() {
        return nodeIdentifier;
    }

    void setConnections(List<LocationNode> connections) {
        this.connected = connections;
    }

    List<LocationNode> getConnected() {
        return connected;
    }

    String getLocValue() {
        return location.getStringLocation();
    }

    void printNodeData() {
        System.out.println("Node Number: " + nodeIdentifier);
        System.out.print("Location: ");
        System.out.println(location.getStringLocation());
        System.out.println("Connected to Nodes: ");
        for (int i = 0; i < connected.size(); i++) {
            LocationNode current = connected.get(i);
            System.out.println("\t Node Number: " + current.getID() + " at location: " + current.getLocValue());
        }
    }

    double calcDistance(Location coordinate) {
        double xdist = (coordinate.getX() - location.getX());
        double ydist = (coordinate.getY() - location.getY());
        xdist *= xdist;
        ydist *= ydist;

        return Math.sqrt(xdist + ydist);
    }

    void createConnections(List<LocationNode> locationList, int numConnections) {
        // Creates a list of size numConnections of nodes to connect to currentNode
        List<LocationNode> connections = new ArrayList<LocationNode>();
        int i = 0;
        while (i < numConnections) {
            int randVal;
            while (true) {
                randVal = random.nextInt(locationList.size());
                if (randVal != nodeIdentifier) {
                    break;
                }
            }
            if (!connections.contains(locationList.get(randVal))) {
                connections.add(locationList.get(randVal));
                i++;
            }
        }
        this.setConnections(connections);
    }
}