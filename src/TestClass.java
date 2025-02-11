import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    @Test
    public void testToMorse() {
        assertEquals(".... . .---", Logic.toMorse("hej"));
        assertEquals(".... . .-.. .-.. ---", Logic.toMorse("hello"));
        assertEquals(".-- --- .-. .-.. -..", Logic.toMorse("world"));
    }

    @Test
    public void testToEnglish() {
        assertEquals("HEJ", Logic.toEnglish(".... . .---"));
        assertEquals("HELLO", Logic.toEnglish(".... . .-.. .-.. ---"));
        assertEquals("WORLD", Logic.toEnglish(".-- --- .-. .-.. -.."));
    }

    @Test
    public void testInvalidMorseCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Logic.toEnglish(".... ---.- .---");
        });
        assertEquals("Ogiltig morsekod: ---.-", exception.getMessage());
    }

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
}



