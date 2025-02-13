package lab08.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements TextInterface {
    private Scanner scanner;

    public TextReader(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String next() {
        return scanner.next();
    }

}