package pages;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

     
    public static Object[][] getLoginData() {
        return new Object[][] {
            {"userFirstName", "userLastName","30","userName@gmail.com","1000000","IT"},
            
            
        };
    }

}
