import org.junit.Before;
import org.junit.Test;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    private IngredientType[] ingredientType;

    @Before
    public void setUp(){
        ingredientType = IngredientType.values();
    }

    @Test
    public void checkEnumIngredientTypeSize(){
        assertNotNull(ingredientType);
        assertEquals(2, ingredientType.length);
    }

    @Test
    public void checkEnumIngredientTypeContainsSAUCE(){
        assertEquals("SAUCE", ingredientType[0].toString());
    }

    @Test
    public void checkEnumIngredientTypeContainsFILLING(){
        assertEquals("FILLING", ingredientType[1].toString());
    }

    @Test
    public void checkEnumIngredientTypeDoesNtContainBUN(){
        String incorrectType = "BUN";
        boolean expected = false;

        String[] arrayStringTypes = Stream.of(IngredientType.values()).map(IngredientType::name).toArray(String[]::new);
        boolean actual = Arrays.asList(arrayStringTypes).contains(incorrectType);
        assertEquals(expected, actual);
    }

    @Test
    public void checkEnumIngredientTypeDoesNtContainEmptyElement(){
        String incorrectType = "";
        boolean expected = false;

        String[] arrayStringTypes = Stream.of(IngredientType.values()).map(IngredientType::name).toArray(String[]::new);
        boolean actual = Arrays.asList(arrayStringTypes).contains(incorrectType);
        assertEquals(expected, actual);
    }
}
