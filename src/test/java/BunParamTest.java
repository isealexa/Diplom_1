import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {

    private final String checkName;
    private final String expectedName;
    private final float checkPrice;
    private final float expectedPrice;
    private final String testDescription;

    public BunParamTest(String checkName, String expectedName, float checkPrice, float expectedPrice, String testDescription){
        this.checkName = checkName;
        this.expectedName = expectedName;
        this.checkPrice = checkPrice;
        this.expectedPrice = expectedPrice;
        this.testDescription = testDescription;
    }

    @Parameterized.Parameters(name = "Test {index} checks methods for Bun class when {4}")
    public static Object[][] getBunParam() {
        return new Object[][] {
                {null, null, (float) 0, (float) 0, "the bun doesn't have name and price = 0"},
                {"", "", (float) 1, (float) 1, "the bun has empty name and price = 1"},
                {"Bun", "Bun", (float) 11.11, (float) 11.11, "the bun has name = Bun and price = 11.11"},
                {"DARK! bun", "DARK! bun", (float) 100, (float) 100, "the bun has name = DARK bun and price = 100"},
        };
    }

    private  Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(checkName, checkPrice);
    }

    @Test
    public void getNameHasToReturnBunsNameAsString(){
        String actualName = bun.getName();
        assertEquals("Метод getName возвращает неправильное значение", expectedName, actualName);
    }

    @Test
    public void getPriceHasToReturnBunsPriceAsFloat(){
        float actualPrice = bun.getPrice();
        assertEquals("Метод getPrice возвращает неправильное значение", expectedPrice, actualPrice, 0);
    }
}
