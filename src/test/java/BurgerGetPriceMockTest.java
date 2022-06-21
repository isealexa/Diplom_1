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

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetPriceMockTest {

    private Burger burger;
    @Mock Bun mockBun;
    @Mock Bun mockSecondBun;
    @Mock Bun mockFreeBun;
    @Mock Ingredient mockIngredientKetchup;
    @Mock Ingredient mockIngredientBeef;
    @Mock Ingredient mockIngredientTomato;
    @Mock Ingredient mockFreeIngredient;

    @Before
    public void setUp(){
        burger = new Burger();
        Mockito.when(mockBun.getPrice()).thenReturn((float) 15);
        Mockito.when(mockSecondBun.getPrice()).thenReturn((float) 23.61);
        Mockito.when(mockFreeBun.getPrice()).thenReturn((float) 0);
        Mockito.when(mockIngredientKetchup.getPrice()).thenReturn((float) 10);
        Mockito.when(mockIngredientBeef.getPrice()).thenReturn((float) 41.66);
        Mockito.when(mockIngredientTomato.getPrice()).thenReturn((float) 18.34);
        Mockito.when(mockFreeIngredient.getPrice()).thenReturn((float) 0);
    }

    public void setMockBurger(int countIngredients) {

        burger.setBuns(mockBun);

        if (countIngredients > 0){
            burger.addIngredient(mockIngredientKetchup);

            if (countIngredients > 1) {
                burger.addIngredient(mockIngredientBeef);

                if (countIngredients > 2) {
                    burger.addIngredient(mockIngredientTomato);
                }
            }
        }
    }

    public void verifyGetPrice(int countIngredients){

        Mockito.verify(mockBun).getPrice();

        if (countIngredients > 0){
            Mockito.verify(mockIngredientKetchup).getPrice();

            if (countIngredients > 1) {
                Mockito.verify(mockIngredientBeef).getPrice();

                if (countIngredients > 2) {
                    Mockito.verify(mockIngredientTomato).getPrice();
                }
            }
        }
    }

    @Test
    //Считаем цену бургера с одним ингридиентом
    public void getPriceWithOneIngredientHasToCountBurgersPriceCorrect(){
        float expectedPrice = (float) 40;
        int countIngredients = 1;
        setMockBurger(countIngredients);

        float actualPrice = burger.getPrice();
        verifyGetPrice(countIngredients);
        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
    }

    @Test
    //Считаем цену бургера с двумя ингридиентами, получим сумму с копейками
    public void getPriceWithTwoIngredientsHasToCountBurgersPriceCorrect(){
        float expectedPrice = (float) 81.66;
        int countIngredients = 2;
        setMockBurger(countIngredients);

        float actualPrice = burger.getPrice();
        verifyGetPrice(countIngredients);
        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
    }

    @Test
    //Считаем цену бургера с тремя ингридиентами, получим круглую сумму
    public void getPriceWithThreeIngredientsHasToCountBurgersPriceCorrect(){
        float expectedPrice = 100;
        int countIngredients = 3;
        setMockBurger(countIngredients);

        float actualPrice = burger.getPrice();
        verifyGetPrice(countIngredients);
        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
    }

    @Test
    //Считаем цену бургера без ингридиентов
    public void getPriceWithoutIngredientsHasToCountBurgersPriceCorrect(){
        float expectedPrice = (float) 30;
        int countIngredients = 0;
        setMockBurger(countIngredients);

        float actualPrice = burger.getPrice();
        verifyGetPrice(countIngredients);
        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
    }

    @Test
    //Считаем цену бургера, если в ней булка по другой цене
    public void getPriceWithAnotherBunHasToCountBurgersPriceCorrect(){
        float expectedPrice = (float) 88.88;
        burger.setBuns(mockSecondBun);
        burger.addIngredient(mockIngredientBeef);
        float actualPrice = burger.getPrice();

        Mockito.verify(mockSecondBun).getPrice();
        Mockito.verify(mockIngredientBeef).getPrice();
        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
    }

    @Test
    //Считаем цену бургера, если булка и ингридиенты бесплатные
    public void getPriceForFreeBurgerHasToCountFreePrice(){
        float expectedPrice = (float) 0;
        burger.setBuns(mockFreeBun);
        burger.addIngredient(mockFreeIngredient);
        float actualPrice = burger.getPrice();

        Mockito.verify(mockFreeBun).getPrice();
        Mockito.verify(mockFreeIngredient).getPrice();
        assertEquals("Цена за бургер посчитана неверно", expectedPrice, actualPrice, 0.001);
    }
}
