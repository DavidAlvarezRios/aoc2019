import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Dia2{

    static List<Integer> program = new ArrayList<>();
    public static void main(String args[]) throws IOException{
        
        program = readFromFile();
        processProgram(12, 2);
        System.out.println(program);
        program = readFromFile();
        findNounAndVerb();

    }

    // Part 1
    public static void processProgram(int noun, int verb){

        program.set(1, noun);
        program.set(2, verb);

        boolean halt = false;
        int i = 0;
        while(i < program.size() && !halt){

            int opcode = program.get(i);
            int result = 0;
            switch(opcode){
                case 1:
                    result = program.get(program.get(i+1)) + program.get(program.get(i+2));
                    program.set(program.get(i+3), result);
                    break;
                case 2:
                    result = program.get(program.get(i+1)) * program.get(program.get(i+2));
                    program.set(program.get(i+3), result);
                    break;
                case 99:
                    halt = true;
                    break;
                default:
                    System.out.println("Opcode not recognized"); // TODO make it an exception
                    break;
            }

            i += 4;
        }

    }

    // Part2
    public static void findNounAndVerb() throws IOException{

        for(int i = 0; i < 99; i++){
            for(int j = 0; j < 99; j++){
                program = readFromFile();
                processProgram(i, j);
                if(program.get(0) == 19690720){
                    System.out.println("100 * noun + verb = "+ (100*i+j));
                }
            }
        }

    }



    // Extract data from file
    public static List<Integer> readFromFile() throws IOException{
        String path = "input";
        Path filePath = Paths.get(path);
        List<Integer> ints = new ArrayList<>();

        try{
            Scanner sc = new Scanner(filePath);
            sc.useDelimiter(",");
            while(sc.hasNext()){
                if(sc.hasNextInt()){
                    ints.add(sc.nextInt());
                }else{
                    sc.next();
                }
            }
            sc.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return ints;
    }


}