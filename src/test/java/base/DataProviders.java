package base;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "items list")
    public Object[][] getItems(){
        return new Object[][]{
                {"bike-light"},
                {"bolt-t-shirt"}
        };
    }
}
