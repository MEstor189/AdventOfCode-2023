package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day3 {

    private static Map<String, List<Integer>> datenbank = new HashMap<>();
    private static int x,y;

    public static ArrayList<char[]> readLines(String filePath) {
        ArrayList<char[]> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                char[] charArray = line.toCharArray();
                linesList.add(charArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesList;
    }

    public static int vailid (ArrayList<char[]> lines){
        String num=""; 
        int sum=0;
        boolean valid = false;
        for(int i=0;i<lines.size();i++){
           // System.out.println(lines.get(i));
             char [] line=lines.get(i);
            
            for (int j=0; j< line.length;j++) {
                char c = line[j];
                if(Character.isDigit(c)){
                    
                    if(!valid){
                    valid=adjacent(lines, i, j, valid);
                    }
                    num= num + c;
               
                   

                    //System.out.println();
                }else if(num!=""){
                    
                    if(valid){

                        stern(x, y, Integer.parseInt(num));

                        sum= sum + Integer.parseInt(num);
                        //System.out.println(num);
                    };
                    num = "";
                    valid=false;
                }                
            }            
        } 
        return sum;
    }

    public static boolean adjacent (ArrayList<char[]> lines, int i, int j, boolean valid){
        
        char [] currline = lines.get(i);
        x=0;
        y=0;


        if(j+1<currline.length){

        //rechts
            if((currline[j+1]=='*')){
                valid = true;
                x=j+1;
                y=i;
            }
        }
        if(j-1>=0){   
            if((currline[j-1]=='*')){
                //System.out.println(currline[j-1]);
                valid = true;   
                x=j-1;
                y=i;
            }
        } 
        //oben
        if(i-1>=0){
            char[] bline = lines.get(i-1);
            //direktoben
            if((bline[j]=='*')){
                valid = true;
                x=j;
                y=i-1;
            }
            if(j+1<bline.length){
            //rechtsoben
                if((bline[j+1]=='*')){
                    valid = true;
                    x=j+1;
                    y=i-1;
                }
            }
            if(j-1>=0){
            //linksoben
                if((bline[j-1]=='*')){
                    valid = true;
                    x=j-1;
                    y=i-1;
                }
            }
        }  
        
        // unten
        if(i+1<lines.size()){

            char[] aline = lines.get(i+1);
            //direktunten
            if((aline[j]=='*')){
                valid=true;
                x=j;
                y=i+1;
            }
            //untenrechts
            if(j+1<aline.length){
            
                if((aline[j+1]=='*')){
                    valid = true;
                    x=(j+1);
                    y=(i+1);
                    //System.out.println(x+":"+y);
                }
            }
            //untenlinks
            if(j-1>=0){
                if((aline[j-1]=='*')){
                    valid = true;
                    x=j-1;
                    y=i+1;
                }
            }

        }
        



        return valid;   // .......421.............#..............+........*....493.......*..........589..................286...............254..........458...672...258
    }

    public static void stern (int x, int y, int num){
        String kombination = x + "&" + y;
        if (datenbank.containsKey(kombination)) {
            // Kombination vorhanden, Zahl hinzufügen
            datenbank.get(kombination).add(num);
        } else {
            // Neue Kombination erstellen
            List<Integer> zahlenListe = new ArrayList<>();
            zahlenListe.add(num);
            datenbank.put(kombination, zahlenListe);
        }

    }

    public static void anzeigen() {
        int sum=0;
        // Anzeigen der gespeicherten Daten
        for (Map.Entry<String, List<Integer>> eintrag : datenbank.entrySet()) {
            List<Integer> zahlenListe = eintrag.getValue();
            if (zahlenListe.size() == 2) {
                // Schlüssel hat genau zwei Zahlen, also ausgeben
                String kombination = eintrag.getKey();
                sum = sum + (zahlenListe.get(0)*zahlenListe.get(1));
                //System.out.println(kombination + ": " + zahlenListe.get(0) + " " + zahlenListe.get(1));
            }
            System.out.println(eintrag.getKey() +": " + zahlenListe);
        }
        System.out.println(sum);
        
    }



    public static void main(String[] args) {
     
        String filePath = "C:/Users/malte/OneDrive/Desktop/AOC2023/d3.txt"; // Passe den Pfad entsprechend an
        ArrayList<char[]> lines = readLines(filePath);
        vailid(lines);
        anzeigen();
        

        // Print the content of the ArrayList
     
    }
}
        

    
        

    

