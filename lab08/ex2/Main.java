package lab08.ex2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("lab08/ex2/testText.txt");

        System.out.println("TextReader:");
        TextInterface textReader = new TextReader(file);
        while (textReader.hasNext()) {
            System.out.print(textReader.next() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("TermFilter:");
        TermFilter termFilter = new TermFilter(new TextReader(file));
        while (termFilter.hasNext()) {
            System.out.print(termFilter.next() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("NormalizationFilter:");
        NormalizationFilter normalizationFilter = new NormalizationFilter(new TermFilter(new TextReader(file)));
        while (normalizationFilter.hasNext()) {
            System.out.print(normalizationFilter.next() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("VowelFilter:");
        VowelFilter vowelFilter = new VowelFilter(new NormalizationFilter(new TermFilter(new TextReader(file))));
        while (vowelFilter.hasNext()) {
            System.out.print(vowelFilter.next() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("CapitalizationFilter:");
        CapitalizationFilter capitalizationFilter = new CapitalizationFilter(
                new VowelFilter(new NormalizationFilter(new TermFilter(new TextReader(file)))));
        while (capitalizationFilter.hasNext()) {
            System.out.print(capitalizationFilter.next() + " ");
        }
    }
}
