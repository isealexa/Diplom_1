import static org.junit.Assert.assertEquals;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;

public class BurgerTest {

    @Test
    public void checkSetBunsExpectedResultIsAddingBun(){
        Bun expectedResult = new Bun("Bun", 17);
        Burger burger = new Burger();
        burger.setBuns(expectedResult);
        Bun actualResult = burger.bun;
        assertEquals("Метод setBuns устанавливает что-то не то", expectedResult, actualResult);
    }
}
