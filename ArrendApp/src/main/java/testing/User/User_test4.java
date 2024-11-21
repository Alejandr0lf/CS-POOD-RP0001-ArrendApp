package testing.User;

import DataBase.DBServices.UserService;
import Model.User.*;

/**
 * TEST 4: CHECK ALL NORMAL USERS OF THE DATABASE
 */
public class User_test4 {
    public static void main(String[] args) {

        UserService newService = new UserService();
        for (User u : newService.check()) {
            System.out.println(u + "\n");
        }
    }
    
}
