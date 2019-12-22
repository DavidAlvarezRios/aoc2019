import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file;

public class Dia2{

    public static void main(String args[]){
        
        List<Integer> program = readFromFile();
        System.out.println(program);

    }

    public static List<Integer> readFromFile(){
        String path = "input";
        Path filePath = Paths.get(path);
        Scanner sc = new Scanner(filePath);
        sc.useDelimiter(",");
        List<Integer> ints = new ArrayList<>();

        while(sc.hasNext()){
            if(sc.hasNextInt()){
                ints.add(sc.nextInt());
            }else{
                sc.next();
            }
        }

        return ints;

    }


}