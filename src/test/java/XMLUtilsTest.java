import hw_14.XMLUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLUtilsTest {

    @Test
    void testValidTag() {
        // Arrange
        String tag = "user";

        // Act
        String result = XMLUtils.createEmptyElement(tag);

        // Assert
        assertEquals("<user></user>", result,
                "Для валидного тега '" + tag + "' должен возвращаться корректный XML-элемент.");
    }

    @Test
    void testNullTag() {
        // Arrange
        String tag = null;

        // Act
        String result = XMLUtils.createEmptyElement(tag);

        // Assert
        assertEquals("<invalid/>", result,
                "Для null-тега должен возвращаться '<invalid/>'.");
    }

    @Test
    void testEmptyTag() {
        // Arrange
        String tag = "";

        // Act
        String result = XMLUtils.createEmptyElement(tag);

        // Assert
        assertEquals("<invalid/>", result,
                "Для пустой строки должен возвращаться '<invalid/>'.");
    }
}