import java.util.HashMap;
import java.util.Map;

public class Logic {

    //Skapar  hashmap för att kunna lagra översättningar
    private static final Map<Character, String> englishToMorse = new HashMap<>();
    private static final Map<String, Character> morseToEnglish = new HashMap<>();

    // Statisk kodblock som körs när klassen laddas, fyller hashmaps med morsekod och bokstäver
    static {
        String[][] morseAlphabet = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},{"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},{"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
                {"Z", "--.."}
        };

        for (String[] pair : morseAlphabet) {
            char letter = pair[0].charAt(0);
            String morse = pair[1];
            englishToMorse.put(letter, morse);
            morseToEnglish.put(morse, letter);

        }
    }
        //Metod som konverterar en textsträng till morsekod
    public static String toMorse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Texten får inte vara tom.");
        }

        StringBuilder morse = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                morse.append("   ");  // Tre mellanslag mellan ord
            } else if (englishToMorse.containsKey(c)) {
                morse.append(englishToMorse.get(c)).append(" ");
            } else {
                throw new IllegalArgumentException("Ogiltigt tecken: " + c);
            }
        }

        return morse.toString().trim();
    }
    //Metod som konverterar en morsekod till engleska
    public static String toEnglish(String morse) {
        if (morse == null || morse.isEmpty()) {
            throw new IllegalArgumentException("Morsekoden får inte vara tom.");
        }

        StringBuilder text = new StringBuilder();
        String[] words = morse.trim().split(" {3}");

        for (String word : words) {
            String[] letters = word.split(" "); // Ett mellanslag mellan bokstäver
            for (String letter : letters) {
                if (morseToEnglish.containsKey(letter)) {
                    text.append(morseToEnglish.get(letter));
                } else {
                    throw new IllegalArgumentException("Ogiltig morsekod: " + letter);
                }
            }
            text.append(" "); // Lägger till ett mellanslag mellan ord
        }

        return text.toString().trim();
    }
}


