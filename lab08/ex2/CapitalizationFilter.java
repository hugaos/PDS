package lab08.ex2;

public class CapitalizationFilter extends TextDecorator {
    public CapitalizationFilter(TextInterface textInterface) {
        super(textInterface);
    }

    @Override
    public String next() {
        String text = super.next();
        return capitalize(text);
    }

    private String capitalize(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        char firstChar = Character.toUpperCase(text.charAt(0));
        char lastChar = Character.toUpperCase(text.charAt(text.length() - 1));
        String middleText = text.substring(1).toLowerCase(); // Removido -1 do índice final

        return firstChar + middleText + lastChar;
    }
}
