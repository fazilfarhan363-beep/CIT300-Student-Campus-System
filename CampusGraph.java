import java.util.*;

public class CampusGraph {

    private Map<String, List<String>> adjacencyList;

    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add campus location
    public boolean addLocation(String location) {

        if (adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.put(location, new ArrayList<>());

        return true;
    }

    // Remove campus location
    public boolean removeLocation(String location) {

        if (!adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.remove(location);

        for (List<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }

        return true;
    }

    // Add connection
    public boolean addConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        if (location1.equals(location2)) {
            return false;
        }

        if (adjacencyList.get(location1).contains(location2)) {
            return false;
        }

        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        return true;
    }

    // Remove connection
    public boolean removeConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        boolean removed1 =
                adjacencyList.get(location1).remove(location2);

        boolean removed2 =
                adjacencyList.get(location2).remove(location1);

        return removed1 && removed2;
    }

    // Display campus network
    public void displayConnections() {

        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("\n========== CAMPUS NETWORK ==========");

        for (String location : adjacencyList.keySet()) {

            System.out.print(location + " -> ");

            List<String> neighbours =
                    adjacencyList.get(location);

            if (neighbours.isEmpty()) {
                System.out.println("No connections");
            } 
            else {
                for (int i = 0; i < neighbours.size(); i++) {

                    System.out.print(neighbours.get(i));

                    if (i < neighbours.size() - 1) {
                        System.out.print(", ");
                    }
                }

                System.out.println();
            }
        }

        System.out.println("=====================================");
    }

    // Display neighbours of one location
    public void displayNeighbours(String location) {

        if (!adjacencyList.containsKey(location)) {
            System.out.println("Location not found.");
            return;
        }

        System.out.println(
                "Connected locations of " + location + ":"
        );

        List<String> neighbours =
                adjacencyList.get(location);

        if (neighbours.isEmpty()) {
            System.out.println("No direct connections.");
        } 
        else {
            for (String neighbour : neighbours) {
                System.out.println("- " + neighbour);
            }
        }
    }

    // BFS traversal
    public void bfs(String startLocation) {

        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Starting location not found.");
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startLocation);
        visited.add(startLocation);

        System.out.println("\n========== BFS TRAVERSAL ==========");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current);

            if (!queue.isEmpty()) {
                System.out.print(" -> ");
            }

            for (String neighbour : adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
        System.out.println("===================================");
    }
}