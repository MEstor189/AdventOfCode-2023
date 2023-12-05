package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class day5 {

    public static void main(String[] args) {

        List<List<Long>> seedToLocationMap = readDataFromFile("C:/Users/Siu/Desktop/aoc2023/d5test.txt");

        // Ausgabe der eingelesenen Daten
        List<Long> seedList = seedToLocationMap.get(0);

        long min = 900000000000000000L;
        seedToLocationMap.remove(0);
        seedToLocationMap.remove(0);
        boolean blockdone = false;
        boolean done = true;
        int counter = 0;
        ArrayList<Long[]> seedPairs = createNewSeeds(seedList);

        for (Long[] seedPair : seedPairs) {

            for (int i = 0; i < seedPair[1]; i++) {
                if (done) {
                    long seed = getLocation(blockdone, seedPair[0] + ((long) i), seedToLocationMap, counter);
                    counter++;
                    blockdone = false;
                    if (seed < min) {
                        min = seed;
                        
                    }else{
                        done = true;
                    }
                }
                
            }
            done=true;

        }

        // sortiert
        // Arrays.sort(erglist);
        System.out.println("test: " + min);

    }

    public static ArrayList<Long[]> createNewSeeds(List<Long> oldSeedList) {
        ArrayList<Long[]> seedpairs = new ArrayList<>();
        List<Long> newSeeds = new ArrayList<>();
        for (int i = 0; i < oldSeedList.size(); i += 2) {
            long num1 = oldSeedList.get(i);
            long num2 = oldSeedList.get(i + 1);
            Long[] pair = { num1, num2 };
            seedpairs.add(pair);
        }

        return seedpairs;

    }


    //map reversen target &dest tauschen

    public static long getLocation(boolean blockdone, long seed, List<List<Long>> seedToLocationMap, long counter) {

        int b = 0;
        long org = seed;
        for (List<Long> list : seedToLocationMap) {

            if (!list.isEmpty()) {
                if (!blockdone) {
                    if (seed >= list.get(1) && seed <= (list.get(1) + list.get(2))) {
                        long diff = seed - list.get(1);
                        // System.out.println(list.get(1));
                        seed = list.get(0) + seed - list.get(1);
                        // System.out.println("diff: "+diff);
                        // System.out.println("newseed: " + seed + "Line: " + b);
                        blockdone = true;

                    } else {
                        seed = seed;
                        // System.out.println("NewOldSeed: " + seed + "line: " + b);
                    }
                }
                b++;
            } else {
                System.out.println();
                blockdone = false;
                //System.out.println("ergebnisSeed: " + seed);
                //System.out.println("-----------");
                //System.out.println("Counter: " + counter);

            }

        }
        System.out.println("Org: "+ org+" Erg: "+seed+ " Count: "+counter);
        System.out.println("|||||||||||||||||||||||||||||||");
        return seed;

    }

    public static List<List<Long>> readDataFromFile(String filename) {
        // Initialisiere das Scanner-Objekt und die Liste für Daten
        Scanner scanner = null;
        List<List<Long>> dataList = new ArrayList<>();

        try {
            // Datei einlesen
            scanner = new Scanner(new File(filename));

            // Lese alle Blöcke in der Datei
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if (!line.isEmpty()) {
                    String[] tokens = line.split(" ");
                    // System.out.println(line);

                    // Konvertiere nur die Token, die Zahlen repräsentieren
                    List<Long> dataBlock = new ArrayList<>();
                    for (String token : tokens) {
                        try {
                            Long data = Long.parseLong(token);
                            dataBlock.add(data);
                        } catch (NumberFormatException e) {
                            // Ignoriere Token, die nicht in Zahlen umgewandelt werden können
                        }
                    }

                    // Füge den Datenblock zur Liste hinzu
                    dataList.add(dataBlock);
                }

            }

        } catch (FileNotFoundException e) {
            // Fehlerbehandlung für den Fall, dass die Datei nicht gefunden wird
            e.printStackTrace();
        } finally {
            // Schließe den Scanner, um Ressourcen freizugeben
            if (scanner != null) {
                scanner.close();
            }
        }

        return dataList;
    }
}
/*
 * 484147517
 * 554268963
 * 1280617623
 * 1296352523
 * 1482622008
 * 1565670012
 * 1791402810
 * 1952856968
 * 2429103736
 * 2585289519
 * 2857206770
 * 2945862860
 * 3267018527
 * 3516186593
 * 3549811819
 * 3552409866
 * 3562009725
 * 3705188833
 * 3974356190
 * 4075212935
 */