import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generation {
    //define terrain constants.
    public static final int EMPTY_SPACE = 0;
    public static final int ASTEROIDS = 1;
    public static final int PLANET = 2;
    public static final int NOVA = 3;
    public static final int SPACE_STATION = 4;
    public static final int BLACK_HOLE = 5;

    public static void main(String[] args) {


        String generatedMap = "";
        int mapDimensionOneSide = 100;

        generatedMap = terrainGenerator(mapDimensionOneSide);
        System.out.println(generatedMap);

        try {
            PrintWriter mapFile = new PrintWriter("map.txt");

            mapFile.print(generatedMap);
            mapFile.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }

    }   //end of main

    public static String terrainGenerator(int mapBorderTiles) {
        String mapOutput = "";
        int mapTileCounter = 0;

        for (int counter = 0; counter < (mapBorderTiles * mapBorderTiles); counter++) {

            //define the percent chances for each type of terrain generation. Empty space will be default.
            double randomGeneration = Math.floor(Math.random() * 100 + 1);   //will generate a number between 1 and 100.
            int rngInt = (int) randomGeneration;    //convert to integer

            //define default spawn rates for terrain. Empty space will be the default.
            int asteroidSpawnRate = 10;
            int planetSpawnRate = 1;
            int novaSpawnRate = 5;
            int spaceStationSpawnRate = 1;
            int blackHoleSpawnRate = 1;

            //if statement to determine if length is at least 1
            if (mapOutput.length() > 0) {

                //switch statement to alter spawn rates.
                switch (mapOutput.length() - 1) {
                    case ASTEROIDS:
                        asteroidSpawnRate += 30;
                    case NOVA:
                        novaSpawnRate += 15;
                }
                if (mapOutput.length() > mapBorderTiles) {
                    switch (mapOutput.length() - mapBorderTiles) {
                        case ASTEROIDS:
                            asteroidSpawnRate += 30;
                        case NOVA:
                            novaSpawnRate += 15;
                    }
                }
            }

            //use an if statement to add number to terrain generation.
            if (rngInt <=
                    (blackHoleSpawnRate)) {
                mapOutput += BLACK_HOLE + " ";
            } else if (rngInt <=
                    (blackHoleSpawnRate + spaceStationSpawnRate)) {
                mapOutput += SPACE_STATION + " ";
            } else if (rngInt <=
                    (blackHoleSpawnRate + spaceStationSpawnRate + novaSpawnRate)) {
                mapOutput += NOVA + " ";
            } else if (rngInt <=
                    (blackHoleSpawnRate + spaceStationSpawnRate + novaSpawnRate + planetSpawnRate)) {
                mapOutput += PLANET + " ";
            } else if (rngInt <=
                    (blackHoleSpawnRate + spaceStationSpawnRate + novaSpawnRate + planetSpawnRate + asteroidSpawnRate)) {
                mapOutput += ASTEROIDS + " ";
            } else {
                mapOutput += EMPTY_SPACE + " ";
            }
            mapTileCounter++;
            if ((mapTileCounter % mapBorderTiles == 0)) {
                mapOutput += "\n";
            }
        }

        return mapOutput;
    }
}   //end of class
