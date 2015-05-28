
package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TeksInlezen {
    public static void main(String[] args) throws IOException {
        String path = "Doolhof/Doolhof1.txt";
        BufferedReader d1 = new BufferedReader(new FileReader(path));
        String line;
        while((line = d1.readLine()) != null){
            System.out.println(line);
        }
        d1.close();
        
        path = "Doolhof/Doolhof2.txt";
        BufferedReader d2 = new BufferedReader(new FileReader(path));
        while((line = d2.readLine()) != null){
            System.out.println(line);
        }
        d2.close();
        
        path = "Doolhof/Doolhof3.txt";
        BufferedReader d3 = new BufferedReader(new FileReader(path));
        while((line = d3.readLine()) != null){
            System.out.println(line);
        }
        d3.close();
    }
    
}
