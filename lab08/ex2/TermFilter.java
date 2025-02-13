package lab08.ex2;

public class TermFilter extends TextDecorator {
    private String[] wordsLine;
    private int currentWordNumber;

    public TermFilter(TextInterface reader) {
        super(reader);
        this.currentWordNumber = 0;
        this.wordsLine = super.next().split(" ");
    }

    @Override
    public boolean hasNext() {
        if (currentWordNumber < wordsLine.length) {
            return true;
        }

        return false;
    }

    @Override
    public String next() {
        String currentWord = wordsLine[this.currentWordNumber];
        currentWordNumber++;
        if (currentWordNumber == wordsLine.length) {
            if (super.hasNext()) {
                wordsLine = super.next().split(" ");
                currentWordNumber = 0;
            }
        }
        return currentWord;
    }
}