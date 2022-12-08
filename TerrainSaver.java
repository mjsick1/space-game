import java.util.PriorityQueue;
import java.util.Queue;

public class TerrainSaver {
    boolean otherWorld = true;
    // Method that checks if the ship is in an alternative world,
    // then creates a queue that saves the terrain info that can
    // be reused once the ship returns.
    public TerrainSaver(String terrain1, String terrain2, String terrain3){
        // Creates Queue
        Queue<String> terrainInfo = new PriorityQueue<>();
        // Adding information into queue, can be modified to use more or less strings
        terrainInfo.add(terrain1);
        terrainInfo.add(terrain2);
        terrainInfo.add(terrain3);
        // Checks if the ship is still in an alternative world
        if(otherWorld){
            System.out.println(terrainInfo);
        }else{
            // For loop to return all the terrainInfo in one string to be read by polling the queue
            for(int n = 0; n <= terrainInfo.size()+1; n++) {
                String finalTerrainInfo = terrainInfo.poll();
                System.out.println("The ship has not yet returned");;
            }
        }
    }
    // An example of how the method is used
    public static void main(String args[]){
        new TerrainSaver("space", "asteroids", "black hole");
    }
}
