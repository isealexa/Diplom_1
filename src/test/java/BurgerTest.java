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

    public void addTestIngredients(){
        burger.addIngredient(ketchup);
        burger.addIngredient(beef);
        burger.addIngredient(tomato);
    }


    @Test
    public void setBunsHasToSetBun(){
        Bun checkBun = new Bun("Bun", 27);
        burger.setBuns(checkBun);
        assertEquals("Метод setBuns устанавливает что-то не то", checkBun, burger.bun);
    }

    @Test
    public void addIngredientHasToAddIngredient(){
        addTestIngredients();

        assertNotNull("Массив ингридиентов оказался пустым", burger.ingredients);
        assertEquals("Размер массива ингридиентов не соответвует ожидаемому",3, burger.ingredients.size());
        assertEquals("Первый элемент в массиве ингридиентов не соотвествет ожидаемому", ketchup, burger.ingredients.get(0));
        assertEquals("Второй элемент в массиве ингридиентов не соотвествет ожидаемому", beef, burger.ingredients.get(1));
        assertEquals("Третий элемент в массиве ингридиентов не соотвествет ожидаемому", tomato, burger.ingredients.get(2));
    }

    @Test
    public void removeIngredientOnceHasToRemoveOneIngredient(){
        addTestIngredients();
        burger.removeIngredient(1);

        assertNotNull("Массив ингридиентов оказался пустым", burger.ingredients);
        assertEquals("Размер массива ингридиентов не соответвует ожидаемому",2, burger.ingredients.size());
        assertFalse("В массиве обнаружен ингридиент, которого там быть не должно", burger.ingredients.contains(beef));
        assertEquals("Первый элемент в массиве ингридиентов не соотвествет ожидаемому", ketchup, burger.ingredients.get(0));
        assertEquals("Второй элемент в массиве ингридиентов не соотвествет ожидаемому", tomato, burger.ingredients.get(1));

    }

    @Test
    public void removeIngredientTreeTimesHasToRemoveAllIngredient(){
        addTestIngredients();
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        burger.removeIngredient(0);

        assertNotNull("Массив ингридиентов не должен быть пустым, даже ", burger.ingredients);
        assertEquals("Размер массива ингридиентов не соответвует ожидаемому",0, burger.ingredients.size());
        assertFalse("В массиве обнаружен ингридиент, которого там быть не должно", burger.ingredients.contains(ketchup));
        assertFalse("В массиве обнаружен ингридиент, которого там быть не должно", burger.ingredients.contains(beef));
        assertFalse("В массиве обнаружен ингридиент, которого там быть не должно", burger.ingredients.contains(tomato));
    }

//    @Test
//    public void moveIngredientHasToMoveIngredient(){
//        addTestIngredients();
//        burger.moveIngredient();
//    }
}
