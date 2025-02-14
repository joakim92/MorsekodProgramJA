import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    // Testar att texten korrekt omvandlas till morsekod
    @Test
    public void testToMorse() {
        assertEquals(".... . .---", Logic.toMorse("hej"));
        assertEquals(".... . .-.. .-.. ---", Logic.toMorse("hello"));
        assertEquals(".-- --- .-. .-.. -..", Logic.toMorse("world"));
    }

    // Testar att morsekod korrekt omvandlas till text
    @Test
    public void testToEnglish() {
        assertEquals("HEJ", Logic.toEnglish(".... . .---"));
        assertEquals("HELLO", Logic.toEnglish(".... . .-.. .-.. ---"));
        assertEquals("WORLD", Logic.toEnglish(".-- --- .-. .-.. -.."));
    }

    // Testar att felaktig morsekod resulterar i ett undantag
    @Test
    public void testInvalidMorseCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Logic.toEnglish(".... ---.- .---");
        });
        assertEquals("Ogiltig morsekod: ---.-", exception.getMessage());
    }

    // Testar att tom input ger rätt felmeddelande
    @Test
    public void testEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Logic.toMorse("");
        });
        assertEquals("Texten får inte vara tom.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Logic.toEnglish("");
        });
        assertEquals("Morsekoden får inte vara tom.", exception.getMessage());
    }


    // Testar hanteringen av ogiltiga tecken i inmatningen
    @Test
    public void testInvalidCharacters() {
        // Testa ogiltiga tecken i texten
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Logic.toMorse("Hello@World");
        });
        assertEquals("Ogiltigt tecken: @", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Logic.toMorse("Test#123");
        });
        assertEquals("Ogiltigt tecken: #", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Logic.toMorse("Hello World!");
        });
        assertEquals("Ogiltigt tecken: !", exception.getMessage());
    }

}




