import org.junit.Before;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
}
