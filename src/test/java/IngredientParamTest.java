import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType checkType;
    private final IngredientType expectedType;
    private final String checkName;
    private final String expectedName;
    private final float checkPrice;
    private final float expectedPrice;
    private final String testDescription;

    public IngredientParamTest(IngredientType checkType, IngredientType expectedType, String checkName, String expectedName, float checkPrice, float expectedPrice, String testDescription){
        this.checkType = checkType;
        this.expectedType = expectedType;
        this.checkName = checkName;
        this.expectedName = expectedName;
        this.checkPrice = checkPrice;
        this.expectedPrice = expectedPrice;
        this.testDescription = testDescription;
    }

    @Parameterized.Parameters(name = "Test {index} checks methods for ingredient class when {6}")
    public static Object[][] getIngredientParam() {
        return new Object[][] {
                {null, null, null, null, (float) 0, (float) 0, "the ingredient doesn't have type, name and price = 0"},
                {SAUCE, SAUCE, "", "", (float) 1, (float) 1, "the ingredient has type = sauce, empty name and price = 1"},
                {SAUCE, SAUCE, "Ketchup", "Ketchup", (float) 11.11, (float) 11.11, "the ingredient has type = sauce, name = Ketchup and price = 11.11"},
                {FILLING, FILLING, "  ", "  ", (float) 22.22, (float) 22.22, "the ingredient has type = filling, empty name and price = 22.22"},
                {FILLING, FILLING, "Beef", "Beef", (float) 100, (float) 100, "the ingredient has type = filling, name = Beef and price = 100"},
        };
    }

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(checkType, checkName, checkPrice);
    }

    @Test
    public void getTypeHasToReturnIngredientsType(){
        IngredientType actualType = ingredient.getType();
        assertEquals("Метод getType возвращает неправильное значение", expectedType, actualType);
    }

    @Test
    public void getNameHasToReturnIngredientsNameAsString(){
        String actualName = ingredient.getName();
        assertEquals("Метод getName возвращает неправильное значение", expectedName, actualName);
    }

    @Test
    public void getPriceHasToReturnIngredientsPriceAsFloat(){
        float actualPrice = ingredient.getPrice();
        assertEquals("Метод getPrice возвращает неправильное значение", expectedPrice, actualPrice, 0);
    }
}
