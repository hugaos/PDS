package lab08.ex2;

public class VowelFilter extends TextDecorator {
    public VowelFilter(TextInterface textInterface) {
        super(textInterface);
    }

    public String next() {
        String[] words = super.next().split(" ");
        String result = "";
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    result += c;
                }
            }
        }
        return result;
    }
}
