package hu.petrik.szuperhosprojekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Veletlen {
   private Veletlen(){} //mintha c# ban statikus osztály lenne
   private static final Random rng = new Random();
    private static final List<String> VEZETEK_NEVEK = feltolt("veznev.txt");
    private static final List<String> FERFI_KERESZT_NEVEK = feltolt("ferfikernev.txt");
    private static final List<String> NOI_KERESZT__NEVEK = feltolt("noikernev.txt");

    private static List<String> feltolt(String fajlnev){
       List<String> lines = new ArrayList<>();
       try {
           BufferedReader reader = new BufferedReader(new FileReader("files/"+fajlnev));
            String line;
            while((line = reader.readLine()) != null && !line.isEmpty()){
                lines.add(line);
            }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       return lines;
   }

    public static int velEgesz(int min,int max)
    {
        return rng.nextInt(min,max+1);
    }

    public static char velKarakter(char min, char max)
    {
        return (char) velEgesz(min,max);
    }

    public static String velVezetekNev(){
        return VEZETEK_NEVEK.get(rng.nextInt(VEZETEK_NEVEK.size()));
    }

    /**
     * Veletlen keresztnévgenerál a beolvasott fájlok alapján
     * @param nem a keresztnév neme. Férfi = true, Nő = false
     * @return generált véletlen keresztnév
     */
    public static String velKereszNev(boolean nem)
    {
        if(nem)
        {
            return FERFI_KERESZT_NEVEK.get(rng.nextInt(FERFI_KERESZT_NEVEK.size()));
        }
        return NOI_KERESZT__NEVEK.get(rng.nextInt(NOI_KERESZT__NEVEK.size()));

    }





}
