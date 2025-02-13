package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
<<<<<<< HEAD
=======
public class WSSolver {
    public static void main(String[] args) throws IOException{
        // Your code here
        double size=0;
        File filesoup=null;
        instWSSolver inst = new instWSSolver();
        try {
            filesoup = new File(args[0]);
>>>>>>> 423a5bed8a2dc7e576876fbf7598fa33972f7cee

public class WSSolver {
    public static void main(String[] args) throws IOException {
        // Your code here

        instWSSolver solver = new instWSSolver();
        File file = new File("sopa.txt");

        ArrayList<String> keywords = solver.findWords(file);

        for (String word : keywords) {
            System.out.println(word);
        }
    }
}