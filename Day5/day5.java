package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day5 {

    public static void main(String[] args) {
        int max = 0;
        int min = 0;

        List<List<Integer>> seedToLocationMap = readDataFromFile("C:/Users/malte/OneDrive/Desktop/AOC2023/d5test.txt");

        // Ausgabe der eingelesenen Daten
        for (List<Integer> dataList : seedToLocationMap) {

            if (!dataList.isEmpty()) {

                int tempmax = dataList.get(1) + dataList.get(2);
                int tempmin = dataList.get(1);
                if (tempmax > max) {
                    max = tempmax;
                }

                if (tempmin < min) {
                    min = tempmin;
                }

                // System.out.println(dataList.get(0));
                for (int data : dataList) {
                    System.out.print(data + " ");

                }
                System.out.println();
            } else {
                System.out.println();
                System.out.println(min);
                System.out.println(max);

                max = 0;
                min = 100;
            }

            // System.out.println(min);

        }
        System.out.println(min);
        System.out.println(max);

    }

    public static List<List<Integer>> readDataFromFile(String filename) {
        // Initialisiere das Scanner-Objekt und die Liste für Daten
        Scanner scanner = null;
        List<List<Integer>> dataList = new ArrayList<>();

        try {
            // Datei einlesen
            scanner = new Scanner(new File(filename));

            // Lese alle Blöcke in der Datei
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if (!line.isEmpty()) {
                    String[] tokens = line.split(" ");

                    // Konvertiere nur die Token, die Zahlen repräsentieren
                    List<Integer> dataBlock = new ArrayList<>();
                    for (String token : tokens) {
                        try {
                            int data = Integer.parseInt(token);
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
