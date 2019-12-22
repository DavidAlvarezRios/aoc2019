import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dia1{

    public static void main(String args[]){
    
        ArrayList<Integer> mass = readFromFile();
        int result = computeFuel(mass);
        int result2 = computeFuel2(mass);
        System.out.println("Result of part 1: "+ result);
        System.out.println("Result of part 2: "+ result2);
        
        
    }

    public static ArrayList<Integer> readFromFile(){
        String path = "input";
        BufferedReader reader;

        ArrayList<Integer> mass = new ArrayList<>();

        try{
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            mass.add(Integer.parseInt(line));
            while(line != null){
                line = reader.readLine();
                if(line != null){
                    mass.add(Integer.parseInt(line));
                }
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        
        return mass;

    }


    // Part 1
    public static int computeFuel(ArrayList<Integer> masses){
        
        int totalFuel = 0;
        int mass = 0;

        for(int i = 0; i < masses.size(); i++){
            mass = masses.get(i);
            totalFuel += (mass / 3) - 2;
        }
        
        return totalFuel;
    }

    // Part 2
    public static int computeFuel2(ArrayList<Integer> masses){
        
        int totalFuel = 0;
        int mass = 0;

        for(int i = 0; i < masses.size(); i++){
            mass = masses.get(i);
            totalFuel += computeTotalFuel(mass, 0);
        }
        
        return totalFuel;
    }

    public static int computeTotalFuel(int mass, int total){
        
        
        mass = (mass / 3) - 2; 
        if(mass <= 0){;
            return total;
        }else{
            total += mass;
            return computeTotalFuel(mass, total);
        }
       
    }

}
