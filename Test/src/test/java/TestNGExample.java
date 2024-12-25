import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNGExample {

    private int number;
    private final String USER_NAME = "Zoidberg";
    private final String USER_PASSWORD = "doctor";

    @BeforeClass
    public void setup() {
        number = 2;
    }

    @AfterClass
    public void tearDown(){
        number = 0;
    }

    @Test(groups = "regress")
    public void simple_calc_test()
    {
        assertEquals(2 + 2, 4, "Wrong number");
    }

    @Test
    public void simple_calc_test2()
    {
        assertEquals(number + 2, 4, "Wrong number");
    }

    @Test(description = "Simple params test")
    @Parameters({"name", "password"})
    public void parameterized_test (String name, String password){
        assertEquals(name, USER_NAME, "Wrong number");
        assertEquals(password, USER_PASSWORD, "Wrong number");
    }

    @Test(dataProvider = "credits", enabled = false)
    public void data_provider_test(String name, String password) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, USER_NAME, "Wrong user new");
        softAssert.assertEquals(password, USER_PASSWORD, "Wrong user new");
        softAssert.assertAll();
    }

    @DataProvider(name = "credits")
    public static Object[][] creditProvider() {
        return new Object[][]{
                {"Zoidberg", "doctor"},
                {"Zoidberg", "capo"},
                {"Leela", "capo"}
        };
    }
}
