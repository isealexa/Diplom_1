import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class BurgerTest {

    private Burger burger;

    @Before
    public void setUp(){
         burger = new Burger();
    }


    @Test
    public void setBunsHasToAddBun(){
        Bun checkBun = new Bun("Bun", 27);
        burger.setBuns(checkBun);
        assertEquals("Метод setBuns устанавливает что-то не то", checkBun, burger.bun);
    }

    @Test
    public void addIngredientHasToAddIngredient(){
        Ingredient ketchup = new Ingredient(SAUCE, "ketchup", 8);
        Ingredient beef = new Ingredient(FILLING,"beef", 53 );
        Ingredient tomato = new Ingredient(FILLING, "tomato", 12);

        burger.addIngredient(ketchup);
        burger.addIngredient(beef);
        burger.addIngredient(tomato);

        assertNotNull(burger.ingredients);
        assertEquals(3, burger.ingredients.size());
        assertEquals(ketchup, burger.ingredients.get(0));
        assertEquals(beef, burger.ingredients.get(1));
        assertEquals(tomato, burger.ingredients.get(2));
    }
}
