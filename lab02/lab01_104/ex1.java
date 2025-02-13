import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ex1 {
    public static void main(String[] args){

        Scanner sc = new Scanner(textFile);

        try{
            File textFile = new File(args[0]);

            ArrayList<ArrayList<Character>> matrix = new ArrayList<ArrayList<Character>>();
            List<String> wordList = new ArrayList<String>();

            String firstLine = sc.nextLine();
            int size = firstLine.length();

            for(int i = 0; i < length; i++){
                matrix.add(new ArrayList<Character>());

                String line = sc.nextLine();

                for(int j = 0; j < size; j++){
                    matrix.get(i).add(j);
                }
            }

            while (sc.hasNextLine()){
                String ln = sc.nextLine();

                String[] lst = ln.split("[,;]");
                for(String s: lst){
                    if(alphabeticCharsOnly(s)){
                        wordList.add(s);
                    }
                }
            }
            sc.close();

            System.out.println(matrix.toString());
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
        }


    }
}