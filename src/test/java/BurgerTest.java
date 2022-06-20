import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

public class BurgerTest {

    private Burger burger;
    private static final Ingredient ketchup = new Ingredient(SAUCE, "ketchup", 8);
    private static final Ingredient beef = new Ingredient(FILLING,"beef", 53 );
    private static final Ingredient tomato = new Ingredient(FILLING, "tomato", 12);

    @Before
    public void setUp(){
         burger = new Burger();
    }


    @Test
    public void setBunsHasToSetBun(){
        Bun checkBun = new Bun("Bun", 27);
        burger.setBuns(checkBun);
        assertEquals("Метод setBuns устанавливает что-то не то", checkBun, burger.bun);
    }

    @Test
    public void addIngredientHasToAddIngredient(){
        burger.addIngredient(ketchup);
        burger.addIngredient(beef);
        burger.addIngredient(tomato);

        assertNotNull(burger.ingredients);
        assertEquals(3, burger.ingredients.size());
        assertEquals(ketchup, burger.ingredients.get(0));
        assertEquals(beef, burger.ingredients.get(1));
        assertEquals(tomato, burger.ingredients.get(2));
    }

    @Test
    public void removeIngredientHasToRemoveIngredient(){
        burger.addIngredient(ketchup);
        burger.addIngredient(beef);
        burger.addIngredient(tomato);

        burger.removeIngredient(1);
        assertNotNull(burger.ingredients);
        assertEquals(2, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(beef));
        assertEquals(ketchup, burger.ingredients.get(0));
        assertEquals(tomato, burger.ingredients.get(1));
    }
}
