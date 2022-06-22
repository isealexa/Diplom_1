import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {

    private Burger burger;
    private String style;
    @Mock Bun mockLightBun;
    @Mock Bun mockDarkBun;
    @Mock Bun mockFreeBun;
    @Mock Ingredient mockIngredientKetchup;
    @Mock Ingredient mockIngredientMayo;
    @Mock Ingredient mockIngredientBeef;
    @Mock Ingredient mockIngredientTomato;
    @Mock Ingredient mockFreeIngredient;

    @Before
    public void setUp(){
        burger = new Burger();
        Mockito.when(mockLightBun.getPrice()).thenReturn((float) 15);
        Mockito.when(mockDarkBun.getPrice()).thenReturn((float) 25.01);
        Mockito.when(mockFreeBun.getPrice()).thenReturn((float) 0);
        Mockito.when(mockIngredientKetchup.getPrice()).thenReturn((float) 10);
        Mockito.when(mockIngredientMayo.getPrice()).thenReturn((float) 12.34);
        Mockito.when(mockIngredientBeef.getPrice()).thenReturn((float) 50);
        Mockito.when(mockIngredientTomato.getPrice()).thenReturn((float) 17.77);
        Mockito.when(mockFreeIngredient.getPrice()).thenReturn((float) 0);

        Mockito.when(mockLightBun.getName()).thenReturn("Light Bun");
        Mockito.when(mockDarkBun.getName()).thenReturn("Super Dark Bun");
        Mockito.when(mockFreeBun.getName()).thenReturn("Free Bun");
        Mockito.when(mockIngredientKetchup.getName()).thenReturn("Ketchup");
        Mockito.when(mockIngredientMayo.getName()).thenReturn("Olive Mayo");
        Mockito.when(mockIngredientBeef.getName()).thenReturn("Beef");
        Mockito.when(mockIngredientTomato.getName()).thenReturn("Red Tomato");
        Mockito.when(mockFreeIngredient.getName()).thenReturn("cheese");

        Mockito.when(mockIngredientKetchup.getType()).thenReturn(SAUCE);
        Mockito.when(mockIngredientMayo.getType()).thenReturn(SAUCE);
        Mockito.when(mockIngredientBeef.getType()).thenReturn(FILLING);
        Mockito.when(mockIngredientTomato.getType()).thenReturn(FILLING);
        Mockito.when(mockFreeIngredient.getType()).thenReturn(FILLING);
    }

    public void setMockBurger(String style) {

        switch (style) {
            case "free":
                burger.setBuns(mockFreeBun);
                burger.addIngredient(mockFreeIngredient);
                break;
            case "just bun":
                burger.setBuns(mockLightBun);
                break;
            case "bun and ketchup":
                burger.setBuns(mockLightBun);
                burger.addIngredient(mockIngredientKetchup);
                break;
            case "bun and beef":
                burger.setBuns(mockLightBun);
                burger.addIngredient(mockIngredientBeef);
                break;
            case "simple":
                burger.setBuns(mockLightBun);
                burger.addIngredient(mockIngredientKetchup);
                burger.addIngredient(mockIngredientBeef);
                break;
            case "dark":
                burger.setBuns(mockDarkBun);
                burger.addIngredient(mockIngredientKetchup);
                burger.addIngredient(mockIngredientKetchup);
                burger.addIngredient(mockIngredientMayo);
                burger.addIngredient(mockIngredientBeef);
                burger.addIngredient(mockIngredientBeef);
                burger.addIngredient(mockIngredientTomato);
                burger.addIngredient(mockIngredientTomato);
                burger.addIngredient(mockIngredientTomato);
                burger.addIngredient(mockFreeIngredient);
                break;
        }
    }

    public void verifyGetPrice(String style){

        switch (style) {
            case "free":
                Mockito.verify(mockFreeBun).getPrice();
                Mockito.verify(mockFreeIngredient).getPrice();
                break;
            case "just bun":
                Mockito.verify(mockLightBun).getPrice();
                break;
            case "bun and ketchup":
                Mockito.verify(mockLightBun).getPrice();
                Mockito.verify(mockIngredientKetchup).getPrice();
                break;
            case "bun and beef":
                Mockito.verify(mockLightBun).getPrice();
                Mockito.verify(mockIngredientBeef).getPrice();
                break;
            case "simple":
                Mockito.verify(mockLightBun).getPrice();
                Mockito.verify(mockIngredientKetchup).getPrice();
                Mockito.verify(mockIngredientBeef).getPrice();
                break;
            case "dark":
                Mockito.verify(mockDarkBun).getPrice();
                Mockito.verify(mockIngredientKetchup, Mockito.times(2)).getPrice();
                Mockito.verify(mockIngredientMayo).getPrice();
                Mockito.verify(mockIngredientBeef, Mockito.times(2)).getPrice();
                Mockito.verify(mockIngredientTomato, Mockito.times(3)).getPrice();
                Mockito.verify(mockFreeIngredient).getPrice();
                break;
        }
    }

    public String getBurgerReceipt(String style){

        setMockBurger(style);
        String receiptBurger = null;

        switch (style) {
            case "free":
                StringBuilder free = new StringBuilder(String.format("(==== Free Bun ====)%n"));
                free.append(String.format("= filling cheese =%n"));
                free.append(String.format("(==== Free Bun ====)%n"));
                free.append(String.format("%nPrice: %f%n", 0.000000));

                receiptBurger = free.toString();
                break;
            case "just bun":
                StringBuilder justBun = new StringBuilder(String.format("(==== Light Bun ====)%n"));
                justBun.append(String.format("(==== Light Bun ====)%n"));
                justBun.append(String.format("%nPrice: %f%n", 30.000000));

                receiptBurger = justBun.toString();
                break;
            case "bun and ketchup":
                StringBuilder bunAndKetchup = new StringBuilder(String.format("(==== Light Bun ====)%n"));
                bunAndKetchup.append(String.format("= sauce Ketchup =%n"));
                bunAndKetchup.append(String.format("(==== Light Bun ====)%n"));
                bunAndKetchup.append(String.format("%nPrice: %f%n", 40.000000));

                receiptBurger = bunAndKetchup.toString();
                break;
            case "bun and beef":
                StringBuilder bunAndBeef = new StringBuilder(String.format("(==== Light Bun ====)%n"));
                bunAndBeef.append(String.format("= filling Beef =%n"));
                bunAndBeef.append(String.format("(==== Light Bun ====)%n"));
                bunAndBeef.append(String.format("%nPrice: %f%n", (float) 80.000000));

                receiptBurger = bunAndBeef.toString();
                break;
            case "simple":
                StringBuilder simple = new StringBuilder(String.format("(==== Light Bun ====)%n"));
                simple.append(String.format("= sauce Ketchup =%n"));
                simple.append(String.format("= filling Beef =%n"));
                simple.append(String.format("(==== Light Bun ====)%n"));
                simple.append(String.format("%nPrice: %f%n", 90.000000));

                receiptBurger = simple.toString();
                break;
            case "dark":
                StringBuilder dark = new StringBuilder(String.format("(==== Super Dark Bun ====)%n"));
                dark.append(String.format("= sauce Ketchup =%n"));
                dark.append(String.format("= sauce Ketchup =%n"));
                dark.append(String.format("= sauce Olive Mayo =%n"));
                dark.append(String.format("= filling Beef =%n"));
                dark.append(String.format("= filling Beef =%n"));
                dark.append(String.format("= filling Red Tomato =%n"));
                dark.append(String.format("= filling Red Tomato =%n"));
                dark.append(String.format("= filling Red Tomato =%n"));
                dark.append(String.format("= filling cheese =%n"));
                dark.append(String.format("(==== Super Dark Bun ====)%n"));
                dark.append(String.format("%nPrice: %f%n", 235.670013));

                receiptBurger = dark.toString();
                break;
        }

        return receiptBurger;
    }

    public void verifyGetNameAndType(String style){

        switch (style) {
            case "free":
                Mockito.verify(mockFreeBun, Mockito.times(2)).getName();
                Mockito.verify(mockFreeIngredient).getType();
                Mockito.verify(mockFreeIngredient).getName();
                break;
            case "just bun":
                Mockito.verify(mockLightBun, Mockito.times(2)).getName();
                break;
            case "bun and ketchup":
                Mockito.verify(mockLightBun, Mockito.times(2)).getName();
                Mockito.verify(mockIngredientKetchup).getType();
                Mockito.verify(mockIngredientKetchup).getName();
                break;
            case "bun and beef":
                Mockito.verify(mockLightBun, Mockito.times(2)).getName();
                Mockito.verify(mockIngredientBeef).getType();
                Mockito.verify(mockIngredientBeef).getName();
                break;
            case "simple":
                Mockito.verify(mockLightBun, Mockito.times(2)).getName();
                Mockito.verify(mockIngredientKetchup).getType();
                Mockito.verify(mockIngredientKetchup).getName();
                Mockito.verify(mockIngredientBeef).getType();
                Mockito.verify(mockIngredientBeef).getName();
                break;
            case "dark":
                Mockito.verify(mockDarkBun, Mockito.times(2)).getName();
                Mockito.verify(mockIngredientKetchup, Mockito.times(2)).getType();
                Mockito.verify(mockIngredientKetchup, Mockito.times(2)).getName();
                Mockito.verify(mockIngredientMayo).getType();
                Mockito.verify(mockIngredientMayo).getName();
                Mockito.verify(mockIngredientBeef, Mockito.times(2)).getType();
                Mockito.verify(mockIngredientBeef, Mockito.times(2)).getName();
                Mockito.verify(mockIngredientTomato, Mockito.times(3)).getType();
                Mockito.verify(mockIngredientTomato, Mockito.times(3)).getName();
                Mockito.verify(mockFreeIngredient).getType();
                Mockito.verify(mockFreeIngredient).getName();
                break;
        }
    }

    @Test
    //Считаем цену бургера с одним ингридиентом - соус
    public void getPriceWithOnlySauceHasToCountBurgersPriceCorrect(){
        style = "bun and ketchup";
        setMockBurger(style);
        float expectedPrice = (float) 40;
        float actualPrice = burger.getPrice();

        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
        verifyGetPrice(style);
    }

    @Test
    //Считаем цену бургера с одним ингридиентом - начинка
    public void getPriceWithOnlyFillingHasToCountBurgersPriceCorrect(){
        style = "bun and beef";
        setMockBurger(style);
        float expectedPrice = (float) 80;
        float actualPrice = burger.getPrice();

        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
        verifyGetPrice(style);
    }

    @Test
    //Считаем цену бургера с двумя ингридиентами, получим круглую сумму
    public void getPriceForSimpleBurgerHasToCountBurgersPriceCorrect(){
        style = "simple";
        setMockBurger(style);
        float expectedPrice = (float) 90;
        float actualPrice = burger.getPrice();

        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
        verifyGetPrice(style);
    }

    @Test
    //Считаем цену дарк бургера: все ингридиенты, получим сумму с копейками
    public void getPriceForDarkBurgerHasToCountBurgersPriceCorrect(){
        style = "dark";
        setMockBurger(style);
        float expectedPrice = (float) 235.67;
        float actualPrice = burger.getPrice();

        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
        verifyGetPrice(style);
    }

    @Test
    //Считаем цену бургера без ингридиентов
    public void getPriceWithoutIngredientsHasToCountBurgersPriceCorrect(){
        style = "just bun";
        setMockBurger(style);
        float expectedPrice = (float) 30;
        float actualPrice = burger.getPrice();

        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
        verifyGetPrice(style);
    }


    @Test
    //Считаем цену бургера, если булка и ингридиенты бесплатные
    public void getPriceForFreeBurgerHasToCountFreePrice(){
        style = "free";
        setMockBurger(style);
        float expectedPrice = 0;
        float actualPrice = burger.getPrice();

        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
        verifyGetPrice(style);
    }

    @Test
    public void getReceiptForBurgerWithOnlySauceHasToReturnReceipt() {
        style = "bun and ketchup";
        String expectedReceipt = getBurgerReceipt(style);
        String actualReceipt = burger.getReceipt();

        assertEquals("Рецепт бургера не соотвествует ожидаемому", expectedReceipt, actualReceipt);
        verifyGetNameAndType(style);
        verifyGetPrice(style);
    }

    @Test
    public void getReceiptForBurgerWithOnlyFillingHasToReturnReceipt() {
        style = "bun and beef";
        String expectedReceipt = getBurgerReceipt(style);
        String actualReceipt = burger.getReceipt();

        assertEquals("Рецепт бургера не соотвествует ожидаемому", expectedReceipt, actualReceipt);
        verifyGetNameAndType(style);
        verifyGetPrice(style);
    }

    @Test
    public void getReceiptForSimpleBurgerHasToReturnReceipt() {
        style = "simple";
        String expectedReceipt = getBurgerReceipt(style);
        String actualReceipt = burger.getReceipt();

        assertEquals("Рецепт бургера не соотвествует ожидаемому", expectedReceipt, actualReceipt);
        verifyGetNameAndType(style);
        verifyGetPrice(style);
    }

    @Test
    public void getReceiptForDarkBurgerHasToReturnReceipt() {
        style = "dark";
        String expectedReceipt = getBurgerReceipt(style);
        String actualReceipt = burger.getReceipt();

        assertEquals("Рецепт бургера не соотвествует ожидаемому", expectedReceipt, actualReceipt);
        verifyGetNameAndType(style);
        verifyGetPrice(style);
    }

    @Test
    public void getReceiptForBurgerWithJustBunHasToReturnReceipt() {
        style = "just bun";
        String expectedReceipt = getBurgerReceipt(style);
        String actualReceipt = burger.getReceipt();

        assertEquals("Рецепт бургера не соотвествует ожидаемому", expectedReceipt, actualReceipt);
        verifyGetNameAndType(style);
        verifyGetPrice(style);
    }

    @Test
    public void getReceiptForFreeBurgerHasToReturnReceipt() {
        style = "free";
        String expectedReceipt = getBurgerReceipt(style);
        String actualReceipt = burger.getReceipt();

        assertEquals("Рецепт бургера не соотвествует ожидаемому", expectedReceipt, actualReceipt);
        verifyGetNameAndType(style);
        verifyGetPrice(style);
    }
}
