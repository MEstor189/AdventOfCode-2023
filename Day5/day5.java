package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class day5 {

    public static void main(String[] args) {
        long max = 0;
        long min = 0;
        long nearseed=9000000000L;

        List<List<Long>> seedToLocationMap = readDataFromFile("C:/Users/malte/OneDrive/Desktop/AOC2023/d5test.txt");

        // Ausgabe der eingelesenen Daten
        List<Long> seedList = seedToLocationMap.get(0);
        List<List<Long>> blocklist = new ArrayList<>();
        seedToLocationMap.remove(0);
        seedToLocationMap.remove(0);
                
        for (Long seed : seedList) {


            for (List<Long> dataList : seedToLocationMap) {
                if (!dataList.isEmpty()) {
                    blocklist.add(dataList);

                    Long tempmax = dataList.get(1) + dataList.get(2);
                    //System.out.println(tempmax);
                    Long tempmin = dataList.get(1);
                    if (tempmax > max) {
                        max = tempmax;
                    }

                    if (tempmin < min) {
                        min = tempmin;
                    }

                    //System.out.println(dataList.get(0));
                    for (Long data : dataList) {
                        System.out.print(data + " ");

                    }
                    System.out.println();
                } else {
                    System.out.println();
                    if(min<=seed&&max>=seed){

                        
                        //System.out.println(min);
                        //System.out.println(max);
                        seed= berechnen(seed, blocklist);


                    }else{
                        blocklist= new ArrayList<>();
                    }

                    max = 0;
                    min = 9000000000L;
                }

                // System.out.println(min);

            }

            if(nearseed>(seed)){
                nearseed=seed;

            }

            System.out.println("-----------------------------");
        }
        System.out.println("Ende: "+ nearseed);

    }

    public static Long berechnen (long seed, List<List<Long>> blocklist){
        Map<Long, Long> datenbank = new HashMap<>();

        for (List<Long> list : blocklist) {
            
            for (long num : list) {
                
                for(long k =0; k<=list.get(2);k++){
                    long key = list.get(1) + k;
                    long value = list.get(0)+k;
                    datenbank.put(key, value);
                }
            }
        }
        System.out.println(datenbank.toString());
        long test = datenbank.get(seed);
        System.out.println("new: "+test);
        return test;

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
