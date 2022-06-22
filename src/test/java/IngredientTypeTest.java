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
        assertNotNull("Класс ENUM IngredientType пустой = NULL", ingredientType);
        assertEquals("Размер класса ENUM не соотвествет", 2, ingredientType.length);
    }

    @Test
    public void checkEnumIngredientTypeContainsSAUCE(){
        assertEquals("В классе ENUM IngredientType допущена опечатка, либо элемент SAUCE отсутвует, либо находится не на своём месте", "SAUCE", ingredientType[0].toString());
    }

    @Test
    public void checkEnumIngredientTypeContainsFILLING(){
        assertEquals("В классе ENUM IngredientType допущена опечатка, либо элемент FILLING отсутвует, либо находится не на своём месте","FILLING", ingredientType[1].toString());
    }

    @Test
    public void checkEnumIngredientTypeDoesNtContainBUN(){
        String incorrectType = "BUN";
        boolean expected = false;

        String[] arrayStringTypes = Stream.of(IngredientType.values()).map(IngredientType::name).toArray(String[]::new);
        boolean actual = Arrays.asList(arrayStringTypes).contains(incorrectType);
        assertEquals("В классе ENUM IngredientType найден элемент BUN, его не должно там быть", expected, actual);
    }

    @Test
    public void checkEnumIngredientTypeDoesNtContainEmptyElement(){
        String incorrectType = "";
        boolean expected = false;

        String[] arrayStringTypes = Stream.of(IngredientType.values()).map(IngredientType::name).toArray(String[]::new);
        boolean actual = Arrays.asList(arrayStringTypes).contains(incorrectType);
        assertEquals("В классе ENUM IngredientType найден пустой элемент, его не должно там быть", expected, actual);
    }
}
