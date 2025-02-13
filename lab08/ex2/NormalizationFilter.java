package lab08.ex2;

import java.text.Normalizer;

public class NormalizationFilter extends TextDecorator {
    public NormalizationFilter(TextInterface textInterface) {
        super(textInterface);
    }

    @Override
    public String next() {
        String text = super.next();
        return normalize(text);
    }

    private String normalize(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        // Remove acentuação
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        normalizedText = normalizedText.replaceAll("[^\\p{ASCII}]", "");

        // Remove pontuação
        normalizedText = normalizedText.replaceAll("\\p{Punct}", "");

        return normalizedText.toLowerCase();
    }
}
