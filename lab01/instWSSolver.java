package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class instWSSolver {

    public ArrayList<String> findWords(File file) throws FileNotFoundException {

        // Lista de palavras a encontrar
        ArrayList<String> Keywords = new ArrayList<String>();
        int size = 40;

        Scanner sc = new Scanner(file);
        try {

            // Ciclo for for que engloba apenas a sopa de letras
            for (int i = 0; i < size; i++) {
                String line = sc.nextLine();

                // Verificar se a linha tem o tamanho correto
                // 1. O puzzle é sempre quadrado, com o tamanho máximo de 40x40
                if (line.length() != size) {
                    System.out.println("Invalid file size");
                    sc.close();
                    System.exit(1);
                }

                // Verificar se existe alguma linha vazia
                if (line.length() == 0) {
                    System.out.println("Empty line.");
                    sc.close();
                    System.exit(1);
                }

                for (int j = 0; j < line.length(); j++) {

                    // Verificar se a linha contém apenas letras
                    // 4. As palavras são compostas por caracteres alfabéticos.
                    if (!Character.isAlphabetic(line.charAt(j))) {
                        System.out.println("Invalid character");
                        sc.close();
                        System.exit(1);
                    }

                    // Verificar se a linha contém letras minúsculas
                    // 2. As letras do puzzle estão em maiúscula
                    if (!Character.isUpperCase(line.charAt(j))) {
                        System.out.println("Lower case character");
                        sc.close();
                        System.exit(1);
                    }
                }
            }
            // Fim do ciclo for que engloba apenas a sopa de letras

            // Ler as palavras a encontrar
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();

                // 5. No puzzle e na lista de palavras, o ficheiro não pode conter linhas
                // vazias.
                if (linha.length() == 0) {
                    System.out.println("Empty line.");
                    sc.close();
                    System.exit(1);
                }

                String[] word = linha.split("[;. ]");

                // 4. As palavras são compostas por caracteres alfabéticos
                // Mais eficaz do que utilizar o método isAlphabetic, pois teria de usar dois
                // ciclos for, um para cada palavra e outro para cada letra
                for (int wordIndex = 0; wordIndex < word.length; wordIndex++) {
                    if (!word[wordIndex].matches("[a-zA-Z]+")) {
                        System.out.println("Invalid character");
                        sc.close();
                        System.exit(1);
                    }
                }

                // 3- Na lista, as palavras podem estar só em minúsculas, ou misturadas.
                for (int wordIndex = 0; wordIndex < word.length; wordIndex++) {
                    if (word[wordIndex].equals(word[wordIndex].toUpperCase())) {
                        System.out.println("There's a word that is all upper case");
                        sc.close();
                        System.exit(1);
                    }

                    // Meter as palavras em maiúsculas
                    word[wordIndex] = word[wordIndex].toUpperCase();
                }

                // 8. A lista de palavras pode conter palavras com partes iguais (por exemplo,
                // pode conter BAG e RUTABAGA). Nestes casos a deteção das palavras mais
                // pequenas não deve ser feita sobre a palavra maior
                for (int wordIndex = 0; wordIndex < word.length; wordIndex++) {
                    for (int wordIndex2 = 0; wordIndex2 < word.length; wordIndex2++) {
                        // Verificar se existem palavras iguais
                        if (word[wordIndex].equals(word[wordIndex2]) && wordIndex != wordIndex2) {
                            System.out.println("Duplicate word");
                            sc.close();
                            System.exit(1);
                        }

                        // Verificar se existem palavras que contêm outras palavras
                        if (word[wordIndex].contains(word[wordIndex2]) && wordIndex != wordIndex2) {
                            System.out.println("Atention, there is a word that contains another word inside");
                        }
                    }
                }
            }
            sc.close();
        } finally {
            sc.close();
        }

        return Keywords;
    }

    public Character[][] soupMatrix(File file, int size) throws FileNotFoundException {
        Scanner sc = null;

        // Cria uma matriz para guardar a sopa de letras
        Character[][] soup = new Character[size][size];

        // Tenta abrir o ficheiro
        try {
            // Se conseguir, cria um scanner para o ficheiro
            sc = new Scanner(file);

            // Para cada linha da sopa de letras
            for (int i = 0; i < size; i++) {
                // Lê a linha
                String line = sc.nextLine();
                // Para cada caracter da linha guarda o caracter na matriz
                for (int j = 0; j < size; j++) {
                    soup[i][j] = Character.toLowerCase(line.charAt(j));
                }
            }
            // Fecha o scanner
            sc.close();
        } catch (FileNotFoundException e) {
            // Se não conseguir, imprime um erro e termina o programa
            System.out.println("ERROR: File not found");
            System.exit(1);
        }

        return soup;
    }

    public Directions wordFinder(Character[][] soup, String word, int row, int col) {

        Directions direction = Directions.None;

        // Verificar se a palavra está na horizontal direita
        if (col + word.length() <= soup.length) {
            int wordIndex = 0;
            for (int i = col; i < col + word.length(); i++) {
                if (soup[row][i] == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
            if (wordIndex == word.length()) {
                direction = Directions.Rigth;
            }
        }

        // Verificar se a palavra está na horizontal esquerda
        if (col - word.length() >= 0) {
            int wordIndex = 0;
            for (int i = col; i > col - word.length(); i--) {
                if (soup[row][i] == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
            if (wordIndex == word.length()) {
                direction = Directions.Left;
            }
        }

        // Verificar se a palavra está na vertical para cima
        if (row - word.length() >= 0) {
            int wordIndex = 0;
            for (int i = row; i > row - word.length(); i--) {
                if (soup[i][col] == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
            if (wordIndex == word.length()) {
                direction = Directions.Up;
            }
        }

        // Verificar se a palavra está na vertical para baixo
        if (row + word.length() <= soup.length) {
            int wordIndex = 0;
            for (int i = row; i < row + word.length(); i++) {
                if (soup[i][col] == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
            if (wordIndex == word.length()) {
                direction = Directions.Down;
            }
        }

        // Verificar se a palavra está na diagonal para cima e para a direita
        if (row - word.length() >= 0 && col + word.length() <= soup.length) {
            int wordIndex = 0;
            for (int i = row, j = col; i > row - word.length() && j < col + word.length(); i--, j++) {
                if (soup[i][j] == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
            if (wordIndex == word.length()) {
                direction = Directions.UpRigth;
            }
        }

        // Verificar se a palavra está na diagonal para cima e para a esquerda
        if (row - word.length() >= 0 && col - word.length() >= 0) {
            int wordIndex = 0;
            for (int i = row, j = col; i > row - word.length() && j > col - word.length(); i--, j--) {
                if (soup[i][j] == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
            if (wordIndex == word.length()) {
                direction = Directions.UpLeft;
            }
        }

        // Verificar se a palavra está na diagonal para baixo e para a direita
        if (row + word.length() <= soup.length && col + word.length() <= soup.length) {
            int wordIndex = 0;
            for (int i = row, j = col; i < row + word.length() && j < col + word.length(); i++, j++) {
                if (soup[i][j] == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
            if (wordIndex == word.length()) {
                direction = Directions.DownRigth;
            }
        }

        // Verificar se a palavra está na diagonal para baixo e para a esquerda
        if (row + word.length() <= soup.length && col - word.length() >= 0) {
            int wordIndex = 0;
            for (int i = row, j = col; i < row + word.length() && j > col - word.length(); i++, j--) {
                if (soup[i][j] == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
            if (wordIndex == word.length()) {
                direction = Directions.DownLeft;
            }
        }
        return direction;
    }

    public void wordsOnFile(Character[][] soup, ArrayList<String> words) throws IOException {
        PrintWriter saveFile = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file to save the results: ");
        String fileName = sc.nextLine();
        sc.close();

        // Tenta criar um ficheiro para guardar os resultados
        try {
            // Cria um ficheiro para guardar os resultados
            FileWriter file = new FileWriter(fileName + "_results.txt");
            saveFile = new PrintWriter(file);

            // Cria uma cópia da sopa de letras
            Character[][] soupCopy = new Character[soup.length][soup[0].length];
            for (int i = 0; i < soup.length; i++) {
                for (int j = 0; j < soup.length; j++) {
                    soupCopy[i][j] = soup[i][j];
                }
            }

            // Para cada palavra da lista de palavras
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                // Para cada posição da sopa de letras
                for (int row = 0; row < soup.length; row++) {
                    for (int col = 0; col < soup.length; col++) {
                        String direction = wordFinder(soup, word, row, col).toString();
                        // Se a palavra for encontrada, marca as letras na cópia da sopa de letras
                        if (direction != Directions.None.toString()) {
                            saveFile.printf("%-30s %-5d %-8s %-10s\n", word, word.length(), (row + 1) + "," + (col + 1),
                                    direction);
                            markSoup(soupCopy, word, row, col, direction);
                        }
                    }
                }
            }

            saveFile.println();

            // Substitui as letras não pertencentes a nenhuma palavra por "."
            for (int row = 0; row < soupCopy.length; row++) {
                for (int col = 0; col < soupCopy.length; col++) {
                    if (soupCopy[row][col] != '.') {
                        saveFile.print(". ");
                    } else {
                        saveFile.printf("%s ", Character.toUpperCase(soup[row][col]));
                    }
                }
                saveFile.println();
            }

            saveFile.close();
        } catch (Exception e) {
            // Se não conseguir criar o ficheiro, termina o programa
            System.out.println("ERROR: Could not create file");
            System.exit(1);
        }
    }

    private void markSoup(Character[][] soup, String word, int row, int col, String direction) {
        int deltaRow = 0, deltaCol = 0;

        // Calcula o deslocamento de linha e coluna
        switch (direction) {
            // Direções horizontais
            case "Right":
                deltaCol = 1;
                break;
            case "Left":
                deltaCol = -1;
                break;
            // Direções verticais
            case "Down":
                deltaRow = 1;
                break;
            case "Up":
                deltaRow = -1;
                break;
            // Direções diagonais
            case "UpLeft":
                deltaRow = -1;
                deltaCol = -1;
                break;
            case "UpRight":
                deltaRow = -1;
                deltaCol = 1;
                break;
            case "DownLeft":
                deltaRow = 1;
                deltaCol = -1;
                break;
            case "DownRight":
                deltaRow = 1;
                deltaCol = 1;
                break;
        }

        // Marca as letras da palavra
        for (int i = 0; i < word.length(); i++) {
            soup[row][col] = '.';
            // Atualiza a posição
            row += deltaRow;
            col += deltaCol;
        }
    }
}
