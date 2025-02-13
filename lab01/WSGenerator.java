
package lab01;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WSGenerator {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println(
                    "Usage: java WSGenerator -i <wordlist> -s <soupsize> optional(-o <outputfile>)");
            System.exit(1);
        }
        String wordlist = null;
        int soupsize = 0;
        String outputfile = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0)=='-'){
                switch (args[i]) {
                    case "-i":
                        wordlist = args[i + 1];
                        break;
                    case "-s":
                        soupsize = Integer.parseInt(args[i + 1]);
                        break;
                    case "-o":
                        outputfile = args[i + 1];
                        break;
                    default:
                        System.out.println("Invalid argument");
                        System.exit(1);
                }

            }
        }
        ArrayList<String> list =getlist(wordlist,soupsize);
        char[][] soup= generateSoup(soupsize,list);
        
        if (outputfile == null) {
            printSoup(soup);
        }else{
            try {
                printfile(outputfile, soup, list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void printfile(String fileName,char[][] soup, ArrayList<String> words) throws IOException {
        PrintWriter saveFile = null;

        try {
            FileWriter file = new FileWriter(fileName);
            saveFile = new PrintWriter(file);

            for(int i = 0 ; i<soup.length ;i++){
                for(int j = 0 ; j<soup.length ; j++)
                    saveFile.printf("%s", soup[i][j]);
                saveFile.println();
            }

            for(String word : words){
                saveFile.printf("%s,", word);
            }

            saveFile.close();
        } catch (Exception e) {
            System.out.println("ERROR: Could not create file");
            System.exit(1);
        }
    }
    
    private static ArrayList<String> getlist(String filename, int size) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] words = linha.split("[,;\\s]+");
                for (String word : words) {
                    /// quero que caso alguma palavra tenha um tamanho maior que o tamanho da sopa,
                    /// o programa termine
                    if (word.length() > size) {
                        System.out.println("Word " + word + " is too big");
                        System.exit(1);
                    }
                    list.add(word);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

    private static char[][] generateSoup(int size, ArrayList<String> list) {
        ArrayList<Position> usedpositions = new ArrayList<Position>();
        char[][] soup = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                soup[i][j] = Character.toUpperCase((char) ('a' + (int) (Math.random() * 26)));
            }
        }
        int x=0,y=0;
        int direction= 9;
        for (String word : list) {
            boolean valid = false;
            int vezes=0;
            while (!valid) {
                if (vezes > 1000) {
                    System.out.println("ERROR: Could not find a valid position for word- " + word);
                    System.exit(1);
                }
                vezes++;
                x = (int) (Math.random() * (soup.length));
                y = (int) (Math.random() * (soup.length));
                direction = (int) (Math.random() * 8);
                switch (direction) {
                    case 0: //cima
                        if (y - word.length() >= -1) {
                            // Verifica se as posições que a palavra vai ocupar já estão ocupadas
                            for (int i = 0; i < word.length(); i++) {
                                // Se estiverem ocupadas, a posição não é válida
                                if (usedpositions.contains(new Position(x, y - i))
                                        && soup[x][y - i] != Character.toUpperCase(word.charAt(i))) {
                                    valid = false;
                                    break;
                                } else {

                                    valid = true;
                                }
                            }
                        }
                        break;
                    case 1: //baixo
                        if (y + word.length() <= soup.length) {
                            for (int i = 0; i < word.length(); i++) {
                                if (usedpositions.contains(new Position(x, y + i))
                                        && soup[x][y + i] != Character.toUpperCase(word.charAt(i))) {
                                    valid = false;
                                  
                                    break;
                                } else {
               
                                    valid = true;
                                }
                            }
                        }
                        break;
                    case 2: //esquerda
                        if (x - word.length() >= -1) {
                            for (int i = 0; i < word.length(); i++) {
                                if (usedpositions.contains(new Position(x - i, y))
                                        && soup[x - i][y] != Character.toUpperCase(word.charAt(i))) {
                                    valid = false;
                                   
                                    break;
                                } else {
                          
                                    valid = true;
                                }
                            }
                        }
                        break;
                    case 3:     //direita
                        if (x + word.length() <= soup.length) {
                            for (int i = 0; i < word.length(); i++) {
                                if (usedpositions.contains(new Position(x + i, y))
                                        && soup[x + i][y] != Character.toUpperCase(word.charAt(i))) {
                                    valid = false;
                                    
                                    break;
                                } else {
                                    
                                    valid = true;
                                }
                            }
                        }
                        break;
                    case 4: //cima esquerda
                        if (x - word.length() >= -1 && y - word.length() >= -1) {
                            
                            for (int i = 0; i < word.length(); i++) {
                                
                                if (usedpositions.contains(new Position(x - i, y - i))
                                        && soup[x - i][y - i] != Character.toUpperCase(word.charAt(i))) {
                                    valid = false;
                                    
                                    break;
                                } else {
                                    
                                    valid = true;
                                }
                            }
                        }
                        break;
                    case 5: //cima direita
                        if (x - word.length() >= -1 && y + word.length() <= soup.length) {
                            for (int i = 0; i < word.length(); i++) {
                                if (usedpositions.contains(new Position(x - i, y + i))
                                        && soup[x - i][y + i] != Character.toUpperCase(word.charAt(i))) {
                                    valid = false;
                                    
                                    break;
                                } else {
                                    
                                    valid = true;
                                }
                            }
                        }
                        break;
                    case 6: //baixo esquerda
                        if (x + word.length() <= soup.length && y - word.length() >= -1) {
                            for (int i = 0; i < word.length(); i++) {
                                if (usedpositions.contains(new Position(x + i, y - i))
                                        && soup[x + i][y - i] != Character.toUpperCase(word.charAt(i))) {
                                    valid = false;
                                    
                                    break;
                                } else {
                                    
                                    valid = true;
                                }
                            }
                        }
                        break;

                    case 7: //baixo direita
                        if (x + word.length() <= soup.length && y + word.length() <= soup.length) {
                            for (int i = 0; i < word.length(); i++) {
                                if (usedpositions.contains(new Position(x + i, y + i))
                                        && soup[x + i][y + i] != Character.toUpperCase(word.charAt(i))) {
                                    valid = false;
                                    
                                    break;
                                } else {
                                    
                                    valid = true;
                                }
                            }
                        }
                        break;
                    case 9:
                        break;
                }
            }
            for (int i = 0; i < word.length(); i++) {
                switch (direction) {
                    case 0:
                        usedpositions.add(new Position(x, y - i));
                        soup[x][y - i] = Character.toUpperCase(word.charAt(i));
                        break;
                    case 1:
                        usedpositions.add(new Position(x, y + i));
                        soup[x][y + i] = Character.toUpperCase(word.charAt(i));
                        break;
                    case 2:
                        usedpositions.add(new Position(x - i, y));
                        soup[x - i][y] = Character.toUpperCase(word.charAt(i));
                        break;
                    case 3:
                        usedpositions.add(new Position(x + i, y));
                        soup[x + i][y] = Character.toUpperCase(word.charAt(i));
                        break;
                    case 4:
                        usedpositions.add(new Position(x - i, y - i));
                        soup[x - i][y - i] = Character.toUpperCase(word.charAt(i));
                        break;
                    case 5:
                        usedpositions.add(new Position(x - i, y + i));
                        soup[x - i][y + i] = Character.toUpperCase(word.charAt(i));
                        break;
                    case 6:
                        usedpositions.add(new Position(x + i, y - i));
                        soup[x + i][y - i] = Character.toUpperCase(word.charAt(i));
                        break;
                    case 7:
                        usedpositions.add(new Position(x + i, y + i));
                        soup[x + i][y + i] = Character.toUpperCase(word.charAt(i));
                        break;
                    case 9:
                        break;
                }
            }

        }
        return soup;
    }

    private static void printSoup(char[][] soup) {
        for (int i = 0; i < soup.length; i++) {
            for (int j = 0; j < soup[i].length; j++) {
                System.out.print(soup[i][j] + " ");
            }
            System.out.println();

        }
    }
}
